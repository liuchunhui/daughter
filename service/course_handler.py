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
from course import CourseModel


def body(**kwargs):
    """body
    """
    return json_encode(kwargs)


class CourseHandler(tornado.web.RequestHandler):

    executor = ThreadPoolExecutor(3)

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def get(self, _course=None):
        try:
            result = yield self._get_courses(_course)
            self.write(body(course=result))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1009, e))

    @run_on_executor
    def _get_courses(self, course):

        course_model = CourseModel()
        result = course_model.get_course(course)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def post(self):

        c_id = self.get_body_argument("c_id")
        course = self.get_body_argument("course")
        try:
            # course = json_decode(course)
            if course is not None and c_id is not None:
                course = self._format_course(c_id, course)
                result = yield self._post_course(course)
                self.write(body(state=0, msg='create success', course=self._json_course(result)))
            else:
                self.write(body(state=1, msg='course is none', ))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1008, e))

    @run_on_executor
    def _post_course(self, course):
        course_model = CourseModel()
        result = course_model.create_course(course)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def put(self):
        id = self.get_body_argument('id')
        c_id = self.get_body_argument('c_id')
        course = self.get_body_argument('course')

        try:
            result = yield self._put_course(id, c_id, course)
            self.write(body(state=0, msg='update success'))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1010, e))

    @run_on_executor
    def _put_course(self, id, c_id, course):
        id = int(id)
        data = {
            'c_id': c_id,
            'course': course
        }
        course_model = CourseModel()
        result = course_model.update_course(id, data)
        return result

    @tornado.web.asynchronous
    @tornado.gen.coroutine
    def delete(self, id):

        try:
            result = yield self._delete_course(id)
            self.write(body(state=0, msg="delete success"))
        except Exception as e:
            logging.error(e)
            logging.error(traceback.format_exc())
            self.set_status(400)
            self.write(
                    ErrorHandle.errorbody(1011, e))

    @run_on_executor
    def _delete_course(self, id):
        id = int(id)
        course_model = CourseModel()
        result = course_model.delete_course(id)
        return result

    def _format_course(self, c_id, course):

        return {
            'c_id': c_id,
            'course': course
        }

    def _json_course(self, result):

        return {
            'c_id': result.id,
            'course': result.course
        }