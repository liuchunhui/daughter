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


class Major(BaseModel):
    """专业　数据表"""

    major = CharField(50, null=False, index=True, unique=True)  # 专业
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class MajorModel:

    def __init__(self):
        pass

    def create_major(self, data):
        return self._create_major(data)

    @staticmethod
    def _create_major(data):
        database.begin()
        major = Major()
        major.create(**data)
        database.commit()

    def get_major(self, major=None):
        return self._get_major(major)

    @staticmethod
    def _get_major(major):
        database.begin()
        m = Major()

        if major is not None:
            return m.select().where(Major.major == major)
        else:
            return None

    def update_major(self, id, data):
        if id is not None:
            return self._update_major(id, data)
        else:
            return None

    @staticmethod
    def _update_major(id, data):
        database.begin()
        date = datetime.datetime.now()
        major = Major.update(
                major=data['major'],
                update_time= date
        ).where(Major.id == id)
        major.execute()
        database.commit()
        return major

    def delete_major(self, id):

        if id is not None:
            return self._delete_major(id)
        else:
            return None

    @staticmethod
    def _delete_major(id):
        database.begin()
        major = Major()
        m = major.delete().where(Major.id == id)
        r = m.execute()
        database.commit()
        return r

if __name__ == '__main__':

    try:
        major = MajorModel()

        # 创建
        # data = {
        #     'major': '12软件工程04'
        # }
        # major.create_major(data)

        # 获取
        # data = major.get_major('12软件工程04')
        # print '_______'
        # for d in data:
        #     d = d.__dict__['_data']
        #     print d['major']
        #     print d['id']

        # 修改
        # data = {
        #     'major': '13软件工程05'
        # }
        # major.update_major('1', data)

        # 删除
        major.delete_major('1')

        pass
    except Exception as e:
        print e
