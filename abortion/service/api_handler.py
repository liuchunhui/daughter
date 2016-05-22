from api_version import APIVERSION
from grade_handler import GradeHandler
from major_handler import MajorHandler
from course_handler import CourseHandler
from term_handler import TermHandler


handler = [
    (r"/api/{apiv}/grade".format(apiv=APIVERSION), GradeHandler),
    (r"/api/{apiv}/grade/(.*)".format(apiv=APIVERSION), GradeHandler),
    (r"/api/{apiv}/major".format(apiv=APIVERSION), MajorHandler),
    (r"/api/{apiv}/major/(.*)".format(apiv=APIVERSION), MajorHandler),
    (r"/api/{apiv}/course".format(apiv=APIVERSION), CourseHandler),
    (r"/api/{apiv}/course/(.*)".format(apiv=APIVERSION), CourseHandler),
    (r"/api/{apiv}/term".format(apiv=APIVERSION), TermHandler),
    (r"/api/{apiv}/term/(.*)".format(apiv=APIVERSION), TermHandler)
]