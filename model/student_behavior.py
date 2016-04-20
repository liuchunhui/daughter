# -*- coding: utf-8 -*-

from peewee import CharField
from peewee import DateTimeField
from peewee import ForeignKeyField
from peewee import Model
from peewee import MySQLDatabase
from config.config import Config

import student_info


Config.load('../config/server.json')
database = MySQLDatabase(Config.mysql_db, **{'threadlocals': True,
                                             'host': Config.mysql_host,
                                             'password': Config.mysql_pwd,
                                             'port': Config.mysql_port,
                                             'user': Config.mysql_user})


class BaseModel(Model):

    class Meta:
        database = database


class StudentBehavior(BaseModel):
    """定义数据表"""

    student = ForeignKeyField(student_info.StudentInfo, related_name='behavior_student')
    term = CharField(50)  # 奖励名称
    time = DateTimeField()  # 奖励时间
    title = CharField(50)  # 奖励名称
    rank = CharField(20)  # 级别
    organization =  CharField(100)  # 奖励单位
    create_time = DateTimeField()  # 创建时间


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
