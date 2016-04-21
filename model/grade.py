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


class Grade(BaseModel):
    """年级　数据表"""

    grade = CharField(20, null=False, index=True, unique=True)  # 年级
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class GradeModel:

    def __init__(self):
        pass

    def create_grade(self, data):
        return self._create_grade(data)

    @staticmethod
    def _create_grade(data):
        database.begin()
        grade = Grade()
        grade.create(**data)
        database.commit()

    def get_grade(self, grade=None):
        return self._get_grade(grade)

    @staticmethod
    def _get_grade(grade):
        database.begin()
        g = Grade()
        if grade is not None:
            return g.select().where(Grade.grade == grade)
        else:
            return None

    def update_grade(self, id, data):
        if id is not None:
            return self._update_grade(id, data)
        else:
            return None

    @staticmethod
    def _update_grade(id, data):
        database.begin()
        date = datetime.datetime.now()
        grade = Grade.update(
                grade=data['grade'],
                update_time= date
        ).where(Grade.id == id)
        grade.execute()
        database.commit()
        return grade

    def delete_grade(self, id):

        if id is not None:
            return self._delete_grade(id)
        else:
            return None

    @staticmethod
    def _delete_grade(id):
        database.begin()
        grade = Grade()
        g = grade.delete().where(Grade.id == id)
        r = g.execute()
        database.commit()
        return r

if __name__ == '__main__':

    try:
        grade = GradeModel()

        # 创建
        # data = {
        #     'grade': '12软件工程04'
        # }
        # grade.create_grade(data)

        # 获取
        # data = grade.get_grade('12软件工程04')
        # print '_______'
        # for d in data:
        #     d = d.__dict__['_data']
        #     print d['grade']
        #     print d['id']

        # 修改
        # data = {
        #     'grade': '13软件工程05'
        # }
        # grade.update_grade('1', data)

        # 删除
        # grade.delete_grade('1')

        pass
    except Exception as e:
        print e
