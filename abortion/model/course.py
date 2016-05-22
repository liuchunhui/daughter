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
from peewee import IntegerField
from peewee import PrimaryKeyField
from config import Config

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


class Course(BaseModel):
    """课程　数据表"""

    id = PrimaryKeyField()
    c_id = CharField(50, null=False, index=True, unique=True)  # 课程ID
    course = CharField(50, null=False, index=True)  # 课程名称
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class CourseModel:

    def __init__(self):
        pass

    def create_course(self, data):
        return self._create_course(data)

    def _create_course(self, data):
        database.begin()
        course = Course()
        result = course.create(**data)
        database.commit()
        return result

    def get_course(self, key=None):
        # return self._get_course(c_id, course)
        return self._get_course(key)

    def _get_course(self, key):
        database.begin()
        c = Course()

        if key is not None:
            return self._json_courses(c.select().where((Course.course.contains(key)) | (Course.c_id.contains(key))))
        else:
            return self._json_courses(c.select())

    def _json_courses(self, data):

        result = []
        for d in data:
            d = d.__dict__['_data']

            result.append({
                'id': d['id'],
                'c_id': d['c_id'],
                'course': d['course']
            })
        return result

    def update_course(self, id, data):
        if id is not None:
            return self._update_course(id, data)
        else:
            return None

    def _update_course(self, id, data):
        database.begin()
        date = datetime.datetime.now()
        course = Course.update(update_time= date, **data).where(Course.id == id)
        course.execute()
        database.commit()
        return course

    def delete_course(self, id):

        if id is not None:
            return self._delete_course(id)
        else:
            return None

    def _delete_course(self, id):
        database.begin()
        course = Course()
        c = course.delete().where(Course.id == id)
        r = c.execute()
        database.commit()
        return r

if __name__ == '__main__':

    try:
        course = CourseModel()

        # 创建
        # data = {
        #     'c_id': 'A002',
        #     'course': 'C++语言'
        # }
        # course.create_course(data)

        # 查询
        # reault = course.get_course()
        # for r in reault:
        #     r = r.__dict__['_data']
        #     print r

        # 修改
        # data = {
        #     'c_id': 'B003',
        #     'course': 'C#'
        # }
        # course.update_course('3', data)

        # 删除
        # course.delete_course(4)
        pass
    except Exception as e:
        print e
