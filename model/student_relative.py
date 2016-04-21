# -*- coding: utf-8 -*-

from peewee import CharField
from peewee import DateTimeField
from peewee import ForeignKeyField
from peewee import Model
from peewee import MySQLDatabase
from config.config import Config
from model import student_info


Config.load('../config/server.json')
database = MySQLDatabase(Config.mysql_db, **{'threadlocals': True,
                                             'host': Config.mysql_host,
                                             'password': Config.mysql_pwd,
                                             'port': Config.mysql_port,
                                             'user': Config.mysql_user})


class BaseModel(Model):

    class Meta:
        database = database


class StudentRelative(BaseModel):
    """定义数据表"""

    student = ForeignKeyField(student_info.StudentInfo, related_name='relative_student')
    RID= CharField(50)  # 身份证号
    relation = CharField(50)  # 称谓
    name = CharField(50)  # 姓名
    workplace = CharField(100)  # 工作单位
    politics_status = CharField(50)  # 政治面貌
    post = CharField(50)  # 职务
    tel = CharField(100)  # 电话
    create_time = DateTimeField()  # 创建时间


class StudentRelativeModel:

    def __init__(self):
        pass

    def create_student_family(self, relative):
        self._create_student_relative(relative)

    @staticmethod
    def _create_student_relative(self, relative):
        database.connect()
        student_relative = StudentRelative()
        student_relative.create(**relative)
        database.close()

    def get_student_relative(self, rid=None):
        infos = self._get_student_relative(rid)

        return infos

    @staticmethod
    def _get_student_relative(self, rid):
        database.connect()
        student_relative = StudentRelative()

        result = student_relative.select().where(student_relative.RID == rid) \
            .order_by(student_relative.create_time.desc())

        return result

    def update_student_relative(self, relative):

        return self._update_student_relative(relative)

    @staticmethod
    def _update_student_relative(self, relative):
        database.connect()
        q = StudentRelative.update(relative).where(StudentRelative.RID == relative['RID'])
        q.execute()
        database.close()

        return q

    def delete_student_relative(self, rid=None):
        if rid is None:
            pass
        else:
            self._delete_student_relative(rid)

    @staticmethod
    def _delete_student_relative(self, rid):
        database.connect()
        q = StudentRelative.delete().where(StudentRelative.RID == rid)
        q.execute()
        database.close()


if __name__ == '__main__':

    pass
    # database.create_table(StudentRelative)