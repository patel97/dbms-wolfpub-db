import java.sql.ResultSet;
import java.sql.*;

public class Queries {
	public static void enter_new_publication(User p) {

		PreparedStatement s1 = null;

		try {
			p.in.nextLine();
			System.out.println("Enter following details: %n " + "1) publication_id %n " + "2) title %n "
					+ "3) typical_topics %n " + "4) type %n 5) periodicity %n %n");

			String publication_id = p.in.nextLine();
			String title = p.in.nextLine();
			String typical_topics = p.in.nextLine();
			String type = p.in.nextLine();
			String periodicity = p.in.nextLine();

			s1 = (PreparedStatement) p.conn.prepareStatement(
					"INSERT INTO Publication (publication_id, title, typical_topics, type, periodicity) VALUES (?,?,?,?,?) ");
			s1.setString(1, publication_id);
			s1.setString(2, title);
			s1.setString(3, typical_topics);
			s1.setString(4, type);
			s1.setString(5, periodicity);

			if (s1.executeUpdate == 1)
				System.out.println("Publication Info added");
			else
				System.out.println("Sorry the Staff info couldn't be added");
		} catch (Exception whatever) {
			System.out.println(whatever);
		}
	}

	public static void update_publication_info(User p) {

		PreparedStatement s2 = null;
		try {
			System.out.println("Enter the publication_id of the record to be updated");

			String pub_id = p.in.nextLine();
			System.out.println(
					"What do you want to update? %n 1) title %n 2) typical_topics %n 3) type %n 4) periodicity %n %n");
			String ch = p.in.nextLine();

			if (ch == 1) {
				System.out.println("Enter the new title : ");
				p.in.nextLine();
				String title1 = p.in.nextLine();

				s2 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Publication SET title = ? WHERE publication_id = ?");

				s2.setString(1, title1);
				s2.setString(2, pub_id);
				if (s2.executeUpdate() == 1)
					System.out.println("Publication Info Updated!");
				else
					System.out.println("Couldn't update the Publication Info");
			} else if (ch == 2) {
				System.out.println("Enter the new typical_topics : ");
				p.in.nextLine();
				String tt1 = p.in.nextLine();

				s2 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Publication SET typical_topics = ? WHERE publication_id = ?");

				s2.setString(1, tt1);
				s2.setString(2, pub_id);
				if (s2.executeUpdate() == 1)
					System.out.println("Publication Info Updated!");
				else
					System.out.println("Couldn't update the Publication Info");
			} else if (ch == 3) {
				System.out.println("Enter the new type : ");
				p.in.nextLine();
				String type1 = p.in.nextLine();

				s2 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Publication SET type = ? WHERE publication_id = ?");

				s2.setString(1, type1);
				s2.setString(2, pub_id);
				if (s2.executeUpdate() == 1)
					System.out.println("Publication Info Updated!");
				else
					System.out.println("Couldn't update the Publication Info");
			} else if (ch == 4) {
				System.out.println("Enter the new periodicity : ");
				p.in.nextLine();
				String period1 = p.in.nextLine();

				s2 = (PreparedStatement) p.conn
						.prepareStatement("UPDATE Publication SET periodicity = ? WHERE publication_id = ?");

				s2.setString(1, period1);
				s2.setString(2, pub_id);
				if (s2.executeUpdate() == 1)
					System.out.println("Publication Info Updated!");
				else
					System.out.println("Couldn't update the Publication Info");
			}
		} catch (Exception whatever) {
			System.out.println(whatever);
		}
	}

}