# -*- coding: utf-8 -*-

from peewee import CharField
from peewee import DateTimeField
from peewee import ForeignKeyField
from peewee import TextField
from peewee import Model
from peewee import MySQLDatabase
from config.config import Config
from model import student_info

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


class StudentPunish(BaseModel):
    """处分　数据表"""

    student = ForeignKeyField(student_info.StudentInfo, related_name='punish_student')
    time = DateTimeField()  # 处分时间
    cause = TextField(default=None)  # 处分原因
    rank = CharField(20)  # 级别
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class StudentRewardModel:

    def __init__(self):
        pass

    def create_student_punish(self, punish):
        self._create_student_punish(punish)

    @staticmethod
    def _create_student_punish(self, punish):
        database.connect()
        student_punish = StudentPunish()
        student_punish.create(**punish)
        database.close()

    def get_student_punish(self, id=None):
        infos = self._get_student_punish(id)

        return infos

    @staticmethod
    def _get_student_punish(self, id):
        database.connect()
        student_punish = StudentPunish()

        result = student_punish.select().where(student_punish.ID == id) \
            .order_by(student_punish.create_time.desc())

        return result

    def update_student_punish(self, punish):

        return self._update_student_punish(punish)

    @staticmethod
    def _update_student_punish(self, punish):
        database.connect()
        q = StudentPunish.update(punish).where(StudentPunish.id == punish['id'])
        q.execute()
        database.close()

        return q

    def delete_student_punish(self, id=None):

        if id is None:
            pass
        else:
            self._delete_student_punish(id)

    @staticmethod
    def _delete_student_punish(self, id):
        database.connect()
        q = StudentPunish.delete().where(StudentPunish.id == id)
        q.execute()
        database.close()


if __name__ == '__main__':

    pass
    # database.create_table(StudentPunish)