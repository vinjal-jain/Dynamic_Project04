package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.co.rays.bean.CourseBean;
import in.co.rays.util.JDBCDataSource;

public class CourseModel {
	public long nextPk() throws Exception {
		long pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_course");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getLong(1);
		}
		return pk + 1;

	}

	public void add(CourseBean bean) throws Exception {
		long pk = nextPk();
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into st_course values(?,?,?,?,?,?,?,?)");
		pstmt.setLong(1, pk);
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getDuration());
		pstmt.setString(4, bean.getDescription());
		pstmt.setString(5, bean.getCreatedBy());
		pstmt.setString(6, bean.getModifiedBy());
		pstmt.setTimestamp(7, bean.getCreatedDatetime());
		pstmt.setTimestamp(8, bean.getModifiedDatetime());
		
		int i = pstmt.executeUpdate();
		System.out.println("query added===>" + i);

	}

	public void update(CourseBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_course set name=?, duration=?, description=?, created_by=?, modified_by=?, created_datetime=?, modified_datetime=? where id=?");

		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getDuration());
		pstmt.setString(3, bean.getDescription());
		pstmt.setString(4, bean.getCreatedBy());
		pstmt.setString(5, bean.getModifiedBy());
		pstmt.setTimestamp(6, bean.getCreatedDatetime());
		pstmt.setTimestamp(7, bean.getModifiedDatetime());
		pstmt.setLong(8, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("data updated ===>" + i);
		JDBCDataSource.closeConnection(conn);
	}
	public void delete(long id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from st_course where id=?");
		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();
		JDBCDataSource.closeConnection(conn);
		System.out.println("Data deleted==>" + i);

	}

	public CourseBean findByPk(long id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(" select * from st_course where id=? ");
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		CourseBean bean = null;
		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));
		}
		return bean;

	}

	public List search(CourseBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer(" select * from st_course where 1=1 ");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getDuration() != null && bean.getDuration().length() > 0) {
				sql.append(" and duration like '" + bean.getDuration() + "%'");
			}
		}
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + " ," + pageSize);
		}
		System.out.println("sql==>" + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));
			list.add(bean);
		}
		return list;

	}
}