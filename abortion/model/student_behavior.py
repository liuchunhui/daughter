# -*- coding: utf-8 -*-
import sys
import os
service_path = os.path.join(
        os.path.dirname(__file__), os.path.join("..", "config"))
sys.path.append(service_path)

from peewee import TextField
from peewee import DateTimeField
from peewee import ForeignKeyField
from peewee import Model
from peewee import MySQLDatabase
from peewee import IntegerField
from peewee import PrimaryKeyField
from config import Config

import student_info
import term
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


class StudentBehavior(BaseModel):
    """在校表现　数据表"""

    id = PrimaryKeyField()
    student = ForeignKeyField(student_info.StudentInfo, related_name='behavior_student')
    term = ForeignKeyField(term.Term, related_name='behavior_term')  # 学期
    behavior = TextField()  # 表现情况
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class StudentBehaviorModel:

    def __init__(self):
        pass

    def create_student_behavior(self, behavior):
        self._create_student_behavior(behavior)

    @staticmethod
    def _create_student_behavior(self, behavior):
        database.connect()
        student_behavior = StudentBehavior()
        student_behavior.create(**behavior)
        database.close()

    def get_student_behavior(self, id=None):
        infos = self._get_student_behavior(id)

        return infos

    @staticmethod
    def _get_student_behavior(self, id):
        database.connect()
        student_behavior = StudentBehavior()

        result = student_behavior.select()\
            .where(student_behavior.ID == id) \
            .order_by(student_behavior.create_time.desc())

        return result

    def update_student_behavior(self, behavior):

        return self._update_student_behavior(behavior)

    @staticmethod
    def _update_student_behavior(self, behavior):
        database.connect()
        q = StudentBehavior.update(behavior).where(StudentBehavior.id == behavior['id'])
        q.execute()
        database.close()

        return q

    def delete_student_behavior(self, id=None):

        if id is None:
            pass
        else:
            self._delete_student_behavior(id)

    @staticmethod
    def _delete_student_behavior(self, id):
        database.connect()
        q = StudentBehavior.delete().where(StudentBehavior.id == id)
        q.execute()
        database.close()


if __name__ == '__main__':

    pass
    # database.create_table(StudentBehavior)
