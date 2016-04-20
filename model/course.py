# -*- coding: utf-8 -*-

from peewee import MySQLDatabase
from peewee import Model
from peewee import CharField
from peewee import DateTimeField
from config.config import Config


Config.load('../config/server.json')
database = MySQLDatabase(Config.mysql_db, **{'threadlocals': True,
                                             'host': Config.mysql_host,
                                             'password': Config.mysql_pwd,
                                             'port': Config.mysql_port,
                                             'user': Config.mysql_user})


class BaseModel(Model):

    class Meta:
        database = database


class Course(BaseModel):
    """定义数据表"""

    CID = CharField(20, null=False, index=True)  # 课程ID
    name = CharField(50, null=False, index=True)  # 课程名称
    create_time = DateTimeField(null=False)  # 创建这条记录的时间


class CourseModel:

    def __init__(self):
        pass


if __name__ == '__main__':

    pass