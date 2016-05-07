import logging
import traceback
import sys
import os
service_path = os.path.join(
        os.path.dirname(__file__), os.path.join("..", "model"))
sys.path.append(service_path)

import tornado
import tornado.web
from tornado.escape import json_decode, json_encode, utf8
from tornado.concurrent import run_on_executor
from concurrent.futures import ThreadPoolExecutor
from errorhandle import ErrorHandle
from major import MajorModel


def body(**kwargs):
    """body
    """
    return json_encode(kwargs)


class MajorHandler(tornado.web.RequestHandler):

    executor = ThreadPoolExecutor(3)

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def get(self, _major=None):
        try:
            result = yield self._get_majors(_major)
            self.write(body(major=result))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1005, e))

    @run_on_executor
    def _get_majors(self, major):

        major_model = MajorModel()
        result = major_model.get_major(major)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def post(self):

        major = self.get_body_argument("major")
        try:
            # major = json_decode(major)
            if major is not None:
                major = self._format_major(major)
                result = yield self._post_major(major)
                self.write(body(state=0, msg='create success', major=self._json_major(result)))
            else:
                self.write(body(state=1, msg='major is none', ))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1004, e))

    @run_on_executor
    def _post_major(self, major):
        major_model = MajorModel()
        result = major_model.create_major(major)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def put(self):
        id = self.get_body_argument('id')
        major = self.get_body_argument('major')

        try:
            result = yield self._put_major(id, major)
            self.write(body(state=0, msg='update success'))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1006, e))

    @run_on_executor
    def _put_major(self, id, major):
        id = int(id)
        data = {
            'major':major
        }
        major_model = MajorModel()
        result = major_model.update_major(id, data)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def delete(self, id):

        try:
            result = yield self._delete_major(id)
            self.write(body(state=0, msg="delete success"))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1007, e))

    @run_on_executor
    def _delete_major(self, id):
        id = int(id)
        major_model = MajorModel()
        result = major_model.delete_major(id)
        return result

    def _format_major(self, major):

        return {
            'major': major
        }

    def _json_major(self, result):

        return {
            'id': result.id,
            'major': result.major
        }