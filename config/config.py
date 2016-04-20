import json


class Config(object):
    """config manager
    """

    server_host = None
    server_port = None
    mysql_host = None
    mysql_user = None
    mysql_pwd = None
    mysql_db = None
    mysql_port = None


    @staticmethod
    def load(configfile):
        """load config file
        """

        with open(configfile, "r") as rf:
            Config.cdict = json.load(rf)

        Config.server_host = Config.cdict["server_host"]
        Config.server_port = Config.cdict["server_port"]
        Config.mysql_host = Config.cdict["mysql_host"]
        Config.mysql_user = Config.cdict["mysql_user"]
        Config.mysql_pwd = Config.cdict["mysql_pwd"]
        Config.mysql_db = Config.cdict["mysql_db"]
        Config.mysql_port = Config.cdict["mysql_port"]


    @staticmethod
    def display():
        """display config
        """
        print(Config.cdict)
