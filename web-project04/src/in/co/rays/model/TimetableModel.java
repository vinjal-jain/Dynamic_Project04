package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.co.rays.bean.TimetableBean;
import in.co.rays.util.JDBCDataSource;

public class TimetableModel {
	

	public long nextPk() throws Exception {
		long pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_timetable");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getLong(1);
		}
		return pk + 1;

	}

	public void add(TimetableBean bean) throws Exception {
		long pk = nextPk();
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into st_timetable values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		pstmt.setLong(1, pk);
		pstmt.setString(2, bean.getSemester());
		pstmt.setString(3, bean.getDescription());
		pstmt.setDate(4, new java.sql.Date(bean.getExamDate().getTime()));
		pstmt.setString(5, bean.getExamTime());
		pstmt.setLong(6,bean.getCourseId());
		pstmt.setString(7,bean.getCourseName());
		pstmt.setLong(8,bean.getSubjectId());
		pstmt.setString(9,bean.getSubjectName());
     	pstmt.setString(10, bean.getCreatedBy());
		pstmt.setString(11, bean.getModifiedBy());
		pstmt.setTimestamp(12, bean.getCreatedDatetime());
		pstmt.setTimestamp(13, bean.getModifiedDatetime());
		
		int i = pstmt.executeUpdate();
		System.out.println("data added ===>" + i);

	}

	public void update(TimetableBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_timetable set semester=?, description=?, exam_date=?, exam_time =?, course_id =?, course_name =? , subject_id = ? , subject_name = ?, created_by=?, modified_by=?, created_datetime=?, modified_datetime=? where id=?");

		pstmt.setString(1, bean.getSemester());
		pstmt.setString(2, bean.getDescription());
		pstmt.setDate(3, new java.sql.Date(bean.getExamDate().getTime()));
		pstmt.setString(4, bean.getExamTime());
		pstmt.setLong(5,bean.getCourseId());
		pstmt.setString(6,bean.getCourseName());
		pstmt.setLong(7,bean.getSubjectId());
		pstmt.setString(8,bean.getSubjectName());
     	pstmt.setString(9, bean.getCreatedBy());
		pstmt.setString(10, bean.getModifiedBy());
		pstmt.setTimestamp(11, bean.getCreatedDatetime());
		pstmt.setTimestamp(12, bean.getModifiedDatetime());
		pstmt.setLong(13,bean.getId());
		
		int i = pstmt.executeUpdate();
        System.out.println("Data updated ===> " + i);
		JDBCDataSource.closeConnection(conn);
	}
	public void delete(long id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from st_timetable where id=?");
		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();
		JDBCDataSource.closeConnection(conn);
		System.out.println("Data deleted==>" + i);

	}

	public TimetableBean findByPk(long id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(" select * from st_timetable where id=? ");
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		TimetableBean bean = null;
		while (rs.next()) {
			bean = new TimetableBean();
			bean.setId(rs.getLong(1));
			bean.setSemester(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setExamDate(rs.getDate(4));
			bean.setExamTime(rs.getString(5));
			bean.setCourseId(rs.getLong(6));
			bean.setCourseName(rs.getString(7));
			bean.setSubjectId(rs.getLong(8));
			bean.setSubjectName(rs.getString(9));
		    bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
		}
		return bean;

	}

	public List search(TimetableBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer(" select * from st_timetable where 1=1 ");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			
		}
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + " ," + pageSize);
		}
		}
		System.out.println("sql==>" + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new TimetableBean();
			bean.setId(rs.getLong(1));
			bean.setSemester(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setExamDate(rs.getDate(4));
			bean.setExamTime(rs.getString(5));
			bean.setCourseId(rs.getLong(6));
			bean.setCourseName(rs.getString(7));
			bean.setSubjectId(rs.getLong(8));
			bean.setSubjectName(rs.getString(9));
		    bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
			list.add(bean);
		}
		return list;

		}
	
	}
	

	