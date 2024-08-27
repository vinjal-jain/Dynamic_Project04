package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.StudentBean;
import in.co.rays.bean.SubjectBean;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.util.JDBCDataSource;

public class SubjectModel {

	public long nextPk() throws Exception {

		long pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_subject");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getLong(1);

		}

		JDBCDataSource.closeConnection(conn);

		return pk + 1;
	}

	public void add(SubjectBean bean) throws Exception {

		SubjectBean existBean = findByName(bean.getName()) ;
		
		if (existBean != null )
		{
			throw new DuplicateRecordException("Name is already exist !");
		}
		
		CollegeModel model = new CollegeModel();
		CollegeBean collegeBean = model.findbypk(bean.getCourseId());
		bean.setName(collegeBean.getName());

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_subject values(?, ?, ?, ?, ?, ?, ?, ?, ?)");

		pstmt.setLong(1,nextPk());
		pstmt.setString(2, bean.getName());
		pstmt.setLong(3,bean.getCourseId());
		pstmt.setString(4,bean.getCourseName());
		pstmt.setString(5, bean.getDescription());
		pstmt.setString(6, bean.getCreatedBy());
		pstmt.setString(7, bean.getModifiedBy());
		pstmt.setTimestamp(8, bean.getCreatedDatetime());
		pstmt.setTimestamp(9, bean.getModifiedDatetime());
		

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data inserted => " + i);

	}

	public void update(SubjectBean bean) throws Exception {
		 SubjectBean existBean = findByName(bean.getName()) ;
	 		
	 		if (existBean != null && bean.getId() != existBean.getId())
	 		{
	 			throw new DuplicateRecordException("Name is already exist !");
	 		}
	 		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_subject set name = ?,course_id = ?, course_name= ?, description = ?, createdBy = ?, modifiedBy = ?, createdDatetime = ?, modifiedDatetime = ? where id = ?");

		
	
		pstmt.setString(1, bean.getName());
		pstmt.setLong(2,bean.getCourseId());
		pstmt.setString(3,bean.getCourseName());
		pstmt.setString(4, bean.getDescription());
		pstmt.setString(5, bean.getCreatedBy());
		pstmt.setString(6, bean.getModifiedBy());
		pstmt.setTimestamp(7, bean.getCreatedDatetime());
		pstmt.setTimestamp(8, bean.getModifiedDatetime());
		pstmt.setLong(9,bean.getId());
		
		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data updated => " + i);

	}

	public void delete(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_subject where id = ?");

		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data deleted => " + i);

	}
	public SubjectBean findByName(String name) throws SQLException {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_subject where name=?");
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		SubjectBean bean = null;
		while (rs.next()) {
			bean = new SubjectBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setCourseId(rs.getLong(3));
			bean.setCourseName(rs.getString(4));
			bean.setDescription(rs.getString(5));
			bean.setCreatedBy(rs.getString(6));
			bean.setModifiedBy(rs.getString(7));
			bean.setCreatedDatetime(rs.getTimestamp(8));
			bean.setModifiedDatetime(rs.getTimestamp(9));
			
		}
		JDBCDataSource.closeConnection(conn);
		return bean;

	}


	public SubjectBean findByPk(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_subject where id = ?");

		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		SubjectBean bean = null;

		while (rs.next()) {
			bean = new SubjectBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setCourseId(rs.getLong(3));
			bean.setCourseName(rs.getString(4));
			bean.setDescription(rs.getString(5));
			bean.setCreatedBy(rs.getString(6));
			bean.setModifiedBy(rs.getString(7));
			bean.setCreatedDatetime(rs.getTimestamp(8));
			bean.setModifiedDatetime(rs.getTimestamp(9));
			
		}

		JDBCDataSource.closeConnection(conn);

		return bean;
	}
		
		public List search(SubjectBean bean, int pageNo, int pageSize) throws Exception {
			Connection conn = JDBCDataSource.getConnection();
			StringBuffer sql = new StringBuffer(" select * from st_Subject where 1=1 ");

			if (bean != null) {
				if (bean.getId() > 0) {
					sql.append(" and id =" + bean.getId());
				}
				if (bean.getName() != null && bean.getName().length() > 0) {
					sql.append(" and name like '" + bean.getName() + "%'");
				}
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				sql.append("  limit  " + pageNo + " ," + pageSize);
			}
			System.out.println("sql=>" + sql);

			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				bean = new SubjectBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setCourseId(rs.getLong(3));
				bean.setCourseName(rs.getString(4));
				bean.setDescription(rs.getString(5));
				bean.setCreatedBy(rs.getString(6));
				bean.setModifiedBy(rs.getString(7));
				bean.setCreatedDatetime(rs.getTimestamp(8));
				bean.setModifiedDatetime(rs.getTimestamp(9));

				list.add(bean);
			}

			return list;
	}
}

	