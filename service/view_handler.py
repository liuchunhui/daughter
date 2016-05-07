import tornado
from tornado import web

class IndexHandler(web.RequestHandler):

    """ index """

    def get(self):
        """get"""

        self.render("index.html")


class StudentHandler(web.RequestHandler):

    """ student """

    def get(self):
        """get"""

        self.render("student.html")


class StudentInfoHandler(web.RequestHandler):

    """ student """

    def get(self):
        """get"""

        self.render("student_info.html")


class GradeHandler(web.RequestHandler):

    """ grade """

    def get(self):
        """get"""

        self.render("grade.html")

handler = [
    (r"/", IndexHandler),
    (r"/index", IndexHandler),
    (r"/student", StudentHandler),
    (r"/student/info", StudentInfoHandler),
    (r"/grade", GradeHandler)
]
