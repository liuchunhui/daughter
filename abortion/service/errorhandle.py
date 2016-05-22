from tornado.escape import json_encode
from tornado.escape import json_decode
import traceback
import logging
codemsg = {
    1000: "create grade error",
    1001: "get grade error",
    1002: "update grade error",
    1003: "delete grade error",
    1004: "create major error",
    1005: "get major error",
    1006: "update major error",
    1007: "delete major error",
    1008: "create course error",
    1009: "get course error",
    1010: "update course error",
    1011: "delete course error",
    1012: "creare term error",
    1013: "get term error",
    1014: "update term error",
    1015: "delete term error"
}


def body(**kwargs):
    """body
    """
    return json_encode(kwargs)


class ErrorHandle(object):

    """error crontrol
    """
    @staticmethod
    def errorbody(code, _exception):
        """make error easy
        """
        _msg = codemsg.get(code)
        exception = str(
                traceback.format_exception_only(type(_exception), _exception)[0])
        if _msg is not None:
            result = body(ret=code, msg=_msg, detail=exception)
            logging.error(result)
            logging.debug(traceback.format_exc())
            return result
        else:
            raise NoErrorCodeDefine(" error code not  define")
