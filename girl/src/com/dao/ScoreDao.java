package com.dao;

import com.model.Score;
import com.model.Student;
import com.model.Teacher;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.StringTokenizer;

/**
 * 成绩 dao
 * Created by huihui on 16-6-6.
 */
public class ScoreDao extends HibernateDaoSupport {

    /**
     * 添加成绩信息
     * @param score
     * @return
     */
    @Transactional(readOnly = false)
    public Integer save (Score score) {
        return (Integer)getHibernateTemplate().save(score);
    }

    /**
     * 修改成绩信息，信息不存在则创建信息
     * @param score
     */
    @Transactional(readOnly = false)
    public void saveOrUpdate (Score score) {
        getHibernateTemplate().saveOrUpdate(score);
    }

    /**
     * 删除成绩信息
     * @param score
     */
    @Transactional(readOnly = false)
    public void delete (Score score) {
        getHibernateTemplate().delete(score);
    }

    /**
     * 获取所有成绩信息
     * @return
     */
    public List<Score> findAll () {
        return (List<Score>)getHibernateTemplate().find("from Score");
    }

    /**
     * 根据教师获取该教师下学生的成绩信息
     * @param teacher
     * @return
     */
    public List<Score> findByTeacherNum (Teacher teacher) {
        return (List<Score>)getHibernateTemplate().
                find("from Score as s where s.syllabus.teacher=?", teacher);
    }

    public List<Score> findByStudentNum (Student student) {
        return (List<Score>)getHibernateTemplate().
                find("from Score as s where s.student=?", student);
    }

    /**
     * 根据成绩的id获取成绩
     * @param id
     * @return
     */
    public Score findById (String id) {
        Integer ID = new Integer(id);
        List<Score> scores = (List<Score>)getHibernateTemplate()
                .find("from Score as s where s.id=?", ID);

        if (scores.size() == 0) {
            return null;
        }else {
            return scores.get(0);
        }
    }
}
