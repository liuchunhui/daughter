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


class StudentReward(BaseModel):
    """定义数据表"""

    student = ForeignKeyField(student_info.StudentInfo, related_name='reward_student')
    time = DateTimeField()  # 奖励时间
    title = CharField(50)  # 奖励名称
    rank = CharField(20)  # 级别
    organization = CharField(100)  # 奖励单位
    create_time = DateTimeField()  # 创建时间


class StudentRewardModel:

    def __init__(self):
        pass

    def create_student_reward(self, reward):
        self._create_student_reward(reward)

    @staticmethod
    def _create_student_reward(self, reward):
        database.connect()
        student_reward = StudentReward()
        student_reward.create(**reward)
        database.close()

    def get_student_reward(self, id=None):
        infos = self._get_student_reward(id)

        return infos

    @staticmethod
    def _get_student_reward(self, id):
        database.connect()
        student_reward = StudentReward()

        result = student_reward.select().where(student_reward.ID == id) \
            .order_by(student_reward.create_time.desc())

        return result

    def update_student_reward(self, reward):

        return self._update_student_reward(reward)

    @staticmethod
    def _update_student_reward(self, reward):
        database.connect()
        q = StudentReward.update(reward).where(StudentReward.id == reward['id'])
        q.execute()
        database.close()

        return q

    def delete_student_reward(self, id=None):

        if id is None:
            pass
        else:
            self._delete_student_reward(id)

    @staticmethod
    def _delete_student_reward(self, id):
        database.connect()
        q = StudentReward.delete().where(StudentReward.id == id)
        q.execute()
        database.close()


if __name__ == '__main__':

    pass

    # database.create_table(StudentReward)