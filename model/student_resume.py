# -*- coding: utf-8 -*-

from peewee import CharField
from peewee import DateTimeField
from peewee import ForeignKeyField
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


class StudentResume(BaseModel):
    """个人简历　数据表"""

    student = ForeignKeyField(student_info.StudentInfo, related_name='resume_student')
    start_time = DateTimeField()  # 开始时间
    end_time = DateTimeField()  # 结束时间
    organization = CharField(50)  # 学习(工作)单位
    duty = CharField(50)  # 职务
    certifier = CharField(50)  # 证明人
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class StudentResumeModel:

    def __init__(self):
        pass

    def create_student_resume(self, resume):
        self._create_student_resume(resume)

    @staticmethod
    def _create_student_resume(self, resume):
        database.connect()
        student_resume = StudentResume()
        student_resume.create(**resume)
        database.close()

    def get_student_resume(self, id=None):
        infos = self._get_student_resume(id)

        return infos

    @staticmethod
    def _get_student_resume(self, id):
        database.connect()
        student_resume = StudentResume()

        result = student_resume.select().where(student_resume.ID == id) \
            .order_by(student_resume.create_time.desc())

        return result

    def update_student_resume(self, resume):

        return self._update_student_resume(resume)

    @staticmethod
    def _update_student_resume(self, resume):
        database.connect()
        q = StudentResume.update(resume).where(StudentResume.SID == resume['SID'])
        q.execute()
        database.close()

        return q

    def delete_student_resume(self, id=None):

        if id is None:
            pass
        else:
            self._delete_student_resume(id)

    @staticmethod
    def _delete_student_resume(self, id):
        database.connect()
        q = StudentResume.delete().where(StudentResume.SID == id)
        q.execute()
        database.close()


if __name__ == '__main__':

    pass

    # todo
    # database.create_table(StudentResumeModel)