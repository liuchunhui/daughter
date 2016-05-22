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
from term import TermModel


def body(**kwargs):
    """body
    """
    return json_encode(kwargs)


class TermHandler(tornado.web.RequestHandler):

    executor = ThreadPoolExecutor(3)

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def get(self, _term=None):
        try:
            result = yield self._get_terms(_term)
            self.write(body(term=result))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1005, e))

    @run_on_executor
    def _get_terms(self, term):

        term_model = TermModel()
        result = term_model.get_term(term)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def post(self):

        term = self.get_body_argument("term")
        try:
            # term = json_decode(term)
            if term is not None:
                term = self._format_term(term)
                result = yield self._post_term(term)
                self.write(body(state=0, msg='create success', term=self._json_term(result)))
            else:
                self.write(body(state=1, msg='term is none', ))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1012, e))

    @run_on_executor
    def _post_term(self, term):
        term_model = TermModel()
        result = term_model.create_term(term)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def put(self):
        id = self.get_body_argument('id')
        term = self.get_body_argument('term')

        try:
            result = yield self._put_term(id, term)
            self.write(body(state=0, msg='update success'))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1014, e))

    @run_on_executor
    def _put_term(self, id, term):
        id = int(id)
        data = {
            'term': term
        }
        term_model = TermModel()
        result = term_model.update_term(id, data)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def delete(self, id):

        try:
            result = yield self._delete_term(id)
            self.write(body(state=0, msg="delete success"))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1015, e))

    @run_on_executor
    def _delete_term(self, id):
        id = int(id)
        term_model = TermModel()
        result = term_model.delete_term(id)
        return result

    def _format_term(self, term):

        return {
            'term': term
        }

    def _json_term(self, result):

        return {
            'id': result.id,
            'term': result.term
        }