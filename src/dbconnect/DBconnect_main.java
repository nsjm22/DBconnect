package dbconnect;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class DBconnect_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int id, year, ton;
		String name;
		ResultSet rs;
		MySQL mysql = new MySQL();
		rs = mysql.selectAll();
		try {
			while(rs.next()){
				id = rs.getInt("id");
				name = rs.getString("name");
				year = rs.getInt("year");
				ton = rs.getInt("ton");
				
				DefaultCategoryDataset data = new DefaultCategoryDataset();
				data.addValue(ton,  "name", "year");
			    
				JFreeChart chart = ChartFactory.createLineChart(
						"import Volume",
						"Year",
						"Ton",
						data,
						PlotOrientation.VERTICAL,
						true,
						false,
						false);
				
				ChartPanel cpanel = new ChartPanel(chart);
				//add(cpanel, BorderLayout.CENTER);
				
				System.out.println("ID：" + id);
				System.out.println("name：" + name);
				System.out.println("year：" + year);
				System.out.println("ton：" + ton);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
