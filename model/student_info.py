# -*- coding: utf-8 -*-

from peewee import MySQLDatabase
from peewee import Model
from peewee import CharField
from peewee import DateTimeField
from peewee import ForeignKeyField
from peewee import TextField
from peewee import IntegerField
from config.config import Config

import datetime
import grade


Config.load('../config/server.json')
database = MySQLDatabase(Config.mysql_db, autocommit=False, **{'threadlocals': True,
                                                              'host': Config.mysql_host,
                                                               'password': Config.mysql_pwd,
                                                               'port': Config.mysql_port,
                                                               'user': Config.mysql_user})


class BaseModel(Model):

    class Meta:
        database = database


class StudentInfo(BaseModel):
    """个人信息　数据表"""

    SID = CharField(20, null=False, index=True)  # 学生ID
    name = CharField(50, null=False)  # 姓名
    sex = CharField(10, null=False)  # 性别
    birth = DateTimeField()  # 出生日期
    grade_major = ForeignKeyField(grade.Grade, related_name='info_grade_major')  # 年级专业
    background = TextField(default=None)  # 家庭出身
    persion_status = CharField(50)  # 本人成分
    cultural_level = CharField(50)  # 文化程度
    politics_status = CharField(50)  # 政治面貌
    nation = CharField(50)  # 民族
    native_place = TextField(default=None)  # 籍贯
    dormitory_num = IntegerField()  # 住宿房间号
    dormitory_tel = CharField(20)  # 宿舍电话
    home_address = TextField(default=None)  # 家庭住址
    home_tel = CharField(20)  # 宿舍电话
    postcode = CharField(20)  # 邮编
    photo = TextField(default=None)  # 照片
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class StudentInfoModel:

    def __init__(self):
        pass

    def create_student_info(self, info):
        self._create_student_info()

    @staticmethod
    def _create_student_info(self, info):
        database.connect()

        student_info = StudentInfo()
        student_info.create(**info)
        database.close()

    def get_student_info(self, sid=None):
        info = self._get_student_info(sid)

        return info

    @staticmethod
    def _get_student_info(self, sid):
        database.connect()
        student_info = StudentInfo()

        result = student_info.select().where(StudentInfo.SID == sid) \
            .order_by(StudentInfo.create_time.desc())

        return result

    def update_student_info(self, info):
        q = self._update_student_info(info)

        return q

    @staticmethod
    def _update_student_info(self, info):
        database.connect()
        q = StudentInfo.update(info).where(StudentInfo.SID == info['SID'])
        q.execute()
        database.close()
        return q

    def delete_student_info(self, sid=None):

        if sid is None:
            pass
        else:
            self._delete_student_info(sid)

    @staticmethod
    def _delete_student_info(self, sid):
        database.connect()
        q = StudentInfo.delete().where(StudentInfo.SID == sid)
        q.execute()
        database.close()



if __name__ == '__main__':

    pass