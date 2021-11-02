package org.iptime.mypj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudyGroupDAO {
    public static int insStudyGroup(StudentGroupInfoVO v) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into t_studentgroup_info_t(sidx, gidx) values(?, ?)";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);

            ps.setInt(1, v.getSidx());
            ps.setInt(2, v.getGidx());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps);
        }
        return 0;
    }

    public static List selStudentGroupList(String val) {
        List list = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        String sql = null;
        try {
            con = DbUtils.getCon();

            if("학생".equals(val)){
                list = new ArrayList<StudentInfoVO>();
                sql = "select idx, nm from t_student_info_t";
            } else if("그룹".equals(val)) {
                list = new ArrayList<GroupInfoVO>();
                sql = "select gp from t_group_info_t";
            } else if("학생그룹".equals(val)){
                list = new ArrayList<StudentGroupInfoVO>();
                sql = "select nm, gp from t_studentgroup_info_t A " +
                        "inner join t_student_info_t B on B.idx = A.sidx " +
                        "inner join t_group_info_t C on C.idx = A.gidx";
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if("학생".equals(val)){
                while (rs.next()) {
                    StudentInfoVO vo = new StudentInfoVO();
                    vo.setIdx(rs.getInt("idx"));
                    vo.setNm(rs.getString("nm"));
                    list.add(vo);
                }
            } else if("그룹".equals(val)) {
                while (rs.next()) {
                    GroupInfoVO vo = new GroupInfoVO();
                    vo.setGp(rs.getInt("gp"));
                    list.add(vo);
                }

            } else if("학생그룹".equals(val)){
                while (rs.next()) {
                    StudentGroupInfoVO vo = new StudentGroupInfoVO();
                    vo.setNm(rs.getString("nm"));
                    vo.setGp(rs.getInt("gp"));
                    list.add(vo);
                }
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con,ps,rs);
        }

        return null;
    }


}
