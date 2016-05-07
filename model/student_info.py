# -*- coding: utf-8 -*-
import sys
import os
service_path = os.path.join(
        os.path.dirname(__file__), os.path.join("..", "config"))
sys.path.append(service_path)

from peewee import MySQLDatabase
from peewee import Model
from peewee import CharField
from peewee import DateTimeField
from peewee import ForeignKeyField
from peewee import TextField
from peewee import IntegerField
from peewee import PrimaryKeyField
from config import Config

import datetime
import grade
import major


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

    id = PrimaryKeyField()
    sid = CharField(20, null=False, unique=True)  # 学生ID
    name = CharField(50, null=False)  # 姓名
    sex = CharField(10, null=False)  # 性别
    birth = DateTimeField()  # 出生日期
    grade = ForeignKeyField(grade.Grade, related_name='info_grade')  # 年级
    major = ForeignKeyField(major.Major, related_name='info_major')  # 专业
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
        self._create_student_info(info)

    @staticmethod
    def _create_student_info(info):
        database.begin()
        student_info = StudentInfo()
        student_info.create(**info)
        database.commit()

    def get_student_info(self, sid=None):
        info = self._get_student_info(sid)

        return info

    @staticmethod
    def _get_student_info(sid):
        database.begin()
        student_info = StudentInfo()

        if sid is not None:
            result = student_info.select().where(StudentInfo.sid == sid) \
                .order_by(StudentInfo.create_time.desc())
        else:
            result = student_info.select()
        database.commit()

        return result

    def update_student_info(self, info):
        q = self._update_student_info(info)

        return q

    @staticmethod
    def _update_student_info(info):
        database.begin()
        try:
            q = StudentInfo.update(**info).where(StudentInfo.sid == info['sid'])
            q.execute()
            database.commit()
        except Exception as e:
            print e

        return q

    def delete_student_info(self, sid=None):

        if sid is None:
            pass
        else:
            self._delete_student_info(sid)

    @staticmethod
    def _delete_student_info(sid):
        database.begin()
        if sid is not None:
            q = StudentInfo.delete().where(StudentInfo.sid == sid)
            q.execute()
            database.commit()
        else:
            pass


if __name__ == '__main__':


    try:
        student_info_model = StudentInfoModel()
        # 创建数据表
        # database.begin()
        # database.create_tables([StudentInfo])
        # database.commit()

        # 创建
        # data = {
        #     'sid': '0002',
        #     'name': 'test',
        #     'sex': '女',
        #     'birth': '20000101',
        #     'grade': '2012',
        #     'major': 'English',
        #     'background': '工薪',
        #     'persion_status': '共青团员',
        #     'cultural_level': '本科',
        #     'politics_status': '公民',
        #     'nation': '汉',
        #     'native_place': '山东',
        #     'dormitory_num': '201',
        #     'dormitory_tel': '1234567',
        #     'home_address': '沂城',
        #     'home_tel': '110',
        #     'postcode': '230000',
        #     'photo': '/imgs/test'
        # }
        #
        # grade_model = grade.GradeModel()
        # data['grade'] = grade_model.get_grade(data['grade'])
        # major_model = major.MajorModel()
        # data['major'] = major_model.get_major(data['major'])
        # student_info_model.create_student_info(data)

        # 获取
        # infos = student_info_model.get_student_info('0001')
        #
        # for info in infos:
        #     print info.id

        # 更新
        # data = {
        #     'sid': '0001',
        #     'name': 'ping',
        #     'sex': '男'
        # }

        # student_info_model.update_student_info(data)
        # student_info_model.delete_student_info('0002')


        pass

    except Exception as e:
        print e


    pass
