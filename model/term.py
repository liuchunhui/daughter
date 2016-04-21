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


class Term(BaseModel):
    """学期　数据表"""

    term = CharField(50, null=False, index=True, unique=True)  # 学期
    create_time = DateTimeField(default=datetime.datetime.now)  # 创建这条记录的时间
    update_time = DateTimeField(default=datetime.datetime.now)  # 修改这条记录的时间


class TermModel:

    def __init__(self):
        pass

    def create_term(self, data):
        return self._create_term(data)

    @staticmethod
    def _create_term(data):
        database.begin()
        term = Term()
        term.create(**data)
        database.commit()

    def get_term(self, t=None):
        return self._get_term(t)

    @staticmethod
    def _get_term(t):
        database.begin()
        term = Term()

        if t is None:
            return term.select()
        else:
            return term.select().where(Term.term == t)

    def update_term(self, id, t):
        if id is not None:
            return self._update_term(id, t)
        else:
            return None

    @staticmethod
    def _update_term(id, t):
        database.begin()
        date = datetime.datetime.now()
        term = Term.update(update_time= date, **t).where(Term.id == id)
        term.execute()
        database.commit()
        return term

    def delete_term(self, id):

        if id is not None:
            return self._delete_term(id)
        else:
            return None

    @staticmethod
    def _delete_term(id):
        database.begin()
        term = Term()
        t = term.delete().where(Term.id == id)
        r = t.execute()
        database.commit()
        return r


if __name__ == '__main__':

    try:
        term_model = TermModel()

        # 创建
        # term_msg = {
        #     'term': '201509-201602'
        # }
        # term_model.create_term(term_msg)

        # 获取
        # arr = term_model.get_term('201503-201507')
        # ii = None
        # for a in arr:
        #     a = a.__dict__['_data']
        #     print a
        #     ii = a['id']
        #
        # print '***'
        # print ii

        #　修改 　
        # term_msg = {
        #     'term': '201603-201607'
        # }
        # tt = term_model.update_term(ii, term_msg)
        # print '---------'
        # print tt

        # 删除
        # term_model.delete_term('5')

        pass

    except Exception as e:
        print(e)
