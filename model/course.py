# -*- coding: utf-8 -*-

from peewee import MySQLDatabase
from peewee import Model
from peewee import CharField
from peewee import DateTimeField
from config.config import Config

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

    c_id = CharField(50, null=False, index=True, unique=True)  # 课程ID
    course = CharField(50, null=False, index=True)  # 课程名称
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class CourseModel:

    def __init__(self):
        pass

    def create_course(self, data):
        return self._create_course(data)

    @staticmethod
    def _create_course(data):
        database.begin()
        course = Course()
        course.create(**data)
        database.commit()

    def get_course(self, c_id=None, course=None):

        return self._get_course(c_id, course)

    @staticmethod
    def _get_course(c_id, course):
        database.begin()
        c = Course()

        if c_id is not None and course is not None:
            return c.select().where(Course.c_id == c_id, Course.course == course)
        elif c_id is not None and course is None:
            return c.select().where(Course.c_id == c_id)
        elif c_id is None and course is not None:
            return c.select().where(Course.course == course)
        else:
            return c.select()

    def update_course(self, id, data):
        if id is not None:
            return self._update_course(id, data)
        else:
            return None

    @staticmethod
    def _update_course(id, data):
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

    @staticmethod
    def _delete_course(id):
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
        course.delete_course(4)
        pass
    except Exception as e:
        print e
