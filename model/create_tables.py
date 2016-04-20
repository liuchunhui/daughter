# -*- coding: utf-8 -*-

from peewee import MySQLDatabase
from config.config import Config
import grade_major
import student_info
import student_behavior
import student_punish
import student_relative
import student_resume
import student_reward
import course
import term
import score


if __name__ == '__main__':
    Config.load('../config/server.json')
    database = MySQLDatabase(Config.mysql_db, **{'threadlocals': True,
                                             'host': Config.mysql_host,
                                             'password': Config.mysql_pwd,
                                             'port': Config.mysql_port,
                                             'user': Config.mysql_user})

    # Connect to our database.
    database.connect()

    # Create the tables.
    database.create_tables([
        grade_major.GradeMajor,
        student_info.StudentInfo,
        student_behavior.StudentBehavior,
        student_punish.StudentPunish,
        student_relative.StudentRelative,
        student_resume.StudentResume,
        student_reward.StudentReward,
        course.Course,
        term.Term,
        score.Score
    ], safe=True)
