# -*- coding: utf-8 -*-

from peewee import MySQLDatabase
from peewee import Model
from peewee import CharField
from peewee import DateTimeField
from peewee import ForeignKeyField
from peewee import TextField
from peewee import IntegerField
from config.config import Config

import grade_major


Config.load('../config/server.json')
database = MySQLDatabase(Config.mysql_db, **{'threadlocals': True,
                                             'host': Config.mysql_host,
                                             'password': Config.mysql_pwd,
                                             'port': Config.mysql_port,
                                             'user': Config.mysql_user})


class BaseModel(Model):

    class Meta:
        database = database


class StudentInfo(BaseModel):
    """定义数据表"""

    SID = CharField(20, null=False, index=True)  # 学生ID
    name = CharField(50, null=False)  # 姓名
    sex = CharField(10, null=False)  # 性别
    birth = DateTimeField()  # 出生日期
    grade_major = ForeignKeyField(grade_major.GradeMajor, related_name='belong_grade_major')  # 年级专业
    background = TextField(default=None)  # 家庭出身
    persion_status = CharField(50)  # 本人成分
    culture = CharField(50)  # 文化程度
    politics_status = CharField(50)  # 政治面貌
    nation = CharField(50)  # 民族
    native_place = TextField(default=None)  # 籍贯
    dormitory_num = IntegerField()  # 住宿房间号
    dormitory_tel = CharField(20)  # 宿舍电话
    postcode = CharField(20)  # 邮编
    photo = TextField(default=None)  # 照片
    create_time = DateTimeField(null=False)  # 创建这条记录的时间


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

    # database.create_table(StudentInfo)

    # try:
    #     lognode_edit = LognodeEditModel()
    #     edit_msg = {
    #         "lognode_id": "0000000000",
    #         "edit_user": "liuchunhui_iwm",
    #         "edit_content": "[{'field': 'lognodename', 'old': 'oldname', 'new': 'newname'},{ 'field': 'type', 'old': 'log', 'new': 'alert'}]",
    #         "edit_remark": u"修改日志名称和日志类型"
    #     }
    #     print edit_msg
    #     logging.info(edit_msg)
    #     lognode_edit.create_edit_msg(edit_msg)
    # except Exception as e:
    #     print "主函数"
    #     print e
    # lognode_edit = LognodeEditModel()
    # result = lognode_edit.get_edit_msg(lognodeid=None, approve_result=None, editmsgid=34)
    # print 'result'
    # for value in result:
    #     print value
    #
    # lognode_edit.delete_edit_msg(54)