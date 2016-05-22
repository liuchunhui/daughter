import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
import api_handler
import os

import view_handler


from tornado.options import define, options
define("port", default=8080, help="run on the given port", type=int)

def main():
    tornado.options.parse_command_line()

    settings = {
        "template_path": os.path.join(os.path.dirname(__file__), "../templates"),
        "static_path": os.path.join(os.path.dirname(__file__), "../static"),
        "cookie_secret": "bZJc2sWbQLKos6GkHn/VB9oXwQt8S0R0kRvJ5/xJ89E=",
        "xsrf_cookies": False,  # todo:how to use
        "login_url": "/api/v1/auth"
    }

    handlers = []
    handlers.extend(api_handler.handler)
    handlers.extend(view_handler.handler)

    app = tornado.web.Application(handlers, debug=True, **settings)
    http_server = tornado.httpserver.HTTPServer(app, max_buffer_size=1073741824)
    http_server.listen(options.port)
    tornado.ioloop.IOLoop.instance().start()

if __name__ == "__main__":
    main()