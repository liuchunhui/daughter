# -*- coding: utf-8 -*-
import sys
import os
service_path = os.path.join(
        os.path.dirname(__file__), os.path.join("..", "config"))
sys.path.append(service_path)

from peewee import MySQLDatabase
from peewee import Model
from peewee import BooleanField
from peewee import DateTimeField
from peewee import ForeignKeyField
from peewee import DoubleField
from peewee import IntegerField
from peewee import PrimaryKeyField
from config import Config

import course
import term
import student_info
import datetime

Config.load('../config/server.json')
database = MySQLDatabase(Config.mysql_db, autocommit=False, **{'threadlocals': True,
                                                               'host': Config.mysql_host,
                                                               'password': Config.mysql_pwd,
                                                               'port': Config.mysql_port,
                                                               'user': Config.mysql_user})


class BaseModel(Model):

    class Meta:
        database = database


class Score(BaseModel):
    """成绩　数据表"""

    id = PrimaryKeyField()
    student = ForeignKeyField(student_info.StudentInfo, related_name='score_student')
    course = ForeignKeyField(course.Course, related_name='score_course')  # 成绩所属课程
    term = ForeignKeyField(term.Term, related_name='score_term')  # 成绩所属学期
    score = DoubleField(null=False)  # 成绩
    status = BooleanField(default=False)  # 成绩状态 False:不及格，True:及格
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class ScoreModel:

    def __init__(self):
        pass


if __name__ == '__main__':

    pass