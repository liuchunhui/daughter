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
from grade import GradeModel


def body(**kwargs):
    """body
    """
    return json_encode(kwargs)


class GradeHandler(tornado.web.RequestHandler):

    executor = ThreadPoolExecutor(3)

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def get(self, _grade=None):
        try:
            result = yield self._get_grades(_grade)
            self.write(body(grade=result))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1001, e))

    @run_on_executor
    def _get_grades(self, grade):

        grade_model = GradeModel()
        result = grade_model.get_grade(grade)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def post(self):

        grade = self.get_body_argument("grade")
        try:
            # grade = json_decode(grade)
            if grade is not None:
                grade = self._format_grade(grade)
                result = yield self._post_grade(grade)
                self.write(body(state=0, msg='create success', grade=self._json_grade(result)))
            else:
                self.write(body(state=1, msg='grade not has value', ))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1000, e))


    @run_on_executor
    def _post_grade(self, grade):
        grade_model = GradeModel()
        result = grade_model.create_grade(grade)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def put(self):
        id =  self.get_body_argument('id')
        grade = self.get_body_argument('grade')

        try:
            result = yield self._put_grade(id, grade)
            self.write(body(state=0, msg='update success'))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1002, e))

    @run_on_executor
    def _put_grade(self, id, grade):
        id = int(id)
        data = {
            'grade':grade
        }
        grade_model = GradeModel()
        result = grade_model.update_grade(id, data)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def delete(self, id):

        try:
            result = yield self._delete_grade(id)
            self.write(body(state=0, msg="delete success"))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1003, e))

    @run_on_executor
    def _delete_grade(self, id):
        id = int(id)
        grade_model = GradeModel()
        result = grade_model.delete_grade(id)
        return result

    def _format_grade(self, grade):

        return {
            'grade': grade
        }

    def _json_grade(self, result):

        return {
            'id': result.id,
            'grade': result.grade
        }