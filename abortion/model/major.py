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


class Major(BaseModel):
    """专业　数据表"""

    id = PrimaryKeyField()
    major = CharField(50, null=False, index=True, unique=True)  # 专业
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class MajorModel:

    def __init__(self):
        pass

    def create_major(self, data):
        return self._create_major(data)

    def _create_major(self, data):
        database.begin()
        major = Major()
        result =  major.create(**data)
        database.commit()
        return result

    def get_major(self, major=None):
        return self._get_major(major)

    def _get_major(self, major):
        database.begin()
        m = Major()

        if major is not None:
            return self._json_majors(m.get(Major.major.contains(major)))
        else:
            return self._json_majors(m.select())

    def _json_majors(self, data):

        result = []
        for d in data:
            d = d.__dict__['_data']

            result.append({
                'id': d['id'],
                'major': d['major']
            })
        return result

    def update_major(self, id, data):
        if id is not None:
            return self._update_major(id, data)
        else:
            return None

    def _update_major(self, id, data):
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

    def _delete_major(self, id):
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
        #     'major': 'English'
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
        # major.delete_major('1')

        pass
    except Exception as e:
        print e
