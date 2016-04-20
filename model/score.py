# -*- coding: utf-8 -*-

from peewee import MySQLDatabase
from peewee import Model
from peewee import BooleanField
from peewee import DateTimeField
from peewee import ForeignKeyField
from peewee import DoubleField
from config.config import Config

import course
import term

Config.load('../config/server.json')
database = MySQLDatabase(Config.mysql_db, **{'threadlocals': True,
                                             'host': Config.mysql_host,
                                             'password': Config.mysql_pwd,
                                             'port': Config.mysql_port,
                                             'user': Config.mysql_user})


class BaseModel(Model):

    class Meta:
        database = database


class Score(BaseModel):
    """定义数据表"""

    course = ForeignKeyField(course.Course, related_name='belong_course')  # 成绩所属课程
    term = ForeignKeyField(term.Term, related_name='belong_term')  # 成绩所属学期
    score = DoubleField(null=False)  # 成绩
    status = BooleanField(default=False)  # 成绩状态 False:不及格，True:及格
    create_time = DateTimeField(null=False)  # 创建这条记录的时间


class ScoreModel:

    def __init__(self):
        pass


if __name__ == '__main__':

    pass