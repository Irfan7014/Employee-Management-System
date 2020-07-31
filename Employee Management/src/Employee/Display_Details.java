package Employee;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Display_Details implements ActionListener 
{
    JFrame jf;
    String emp_id,name,fname,age,dob,address,phone,email,edu,jobpost,aadhar;
    JLabel lblimage,title;
    JLabel lblempid,lblname,lblfname,lblage,lbldob,lbladdress,lblphone,lblemail,lbledu,lbljobpost,lblaadhar;
    JLabel alblempid,alblname,alblfname,albldob,albladdress,alblphone,alblemail,albledu,albljobpost;
    JButton bprint,bcancel;
    Display_Details(String empid)
    {
        try
        {
            Databaseconn c=new Databaseconn();
            String q = "select * from employee_details where EmployeeID = '"+empid+"';";
            ResultSet rs = c.s.executeQuery(q);
            while(rs.next())
            {
                emp_id = rs.getString("EmployeeID");
                name = rs.getString("Name");
                fname = rs.getString("FatherName");
                age = rs.getString("Age");
                dob = rs.getString("DOB");
                address = rs.getString("Address");
                phone = rs.getString("Phone");
                email = rs.getString("EmailID");
                edu = rs.getString("Education");
                jobpost = rs.getString("JobPost");
                aadhar = rs.getString("AadharNo");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //JFrame Details
        jf=new JFrame("EMPLOYEE DETAILS");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLocation(30,30);
        jf.setLayout(null);
        jf.setSize(595,642);
        
        //Background Image
        lblimage=new JLabel();
        lblimage.setBounds(0,0,595,642);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src\\Employee\\images\\print.jpg");
        lblimage.setIcon(img);
        jf.add(lblimage);
        
        //Print Details
        title=new JLabel("EMPLOYEE DETAILS");
        title.setBounds(50,10,260,30);
        title.setFont(new Font("Times_New_Roman",Font.BOLD,25));
        lblimage.add(title);
        
        //Label Details
        //1.Employee ID
        lblempid = new JLabel("Employee Id:");
        lblempid.setBounds(50,70,120,30);
        lblempid.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblempid);
        
        alblempid = new JLabel(emp_id);
        alblempid.setBounds(200,70,200,30);
        alblempid.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(alblempid);
        
        //2.Name
        lblname = new JLabel("Name:");
        lblname.setBounds(50,120,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblname);

        alblname = new JLabel(name);
        alblname.setBounds(200,120,300,30);
        alblname.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(alblname);

        //3.Father's Name
        lblfname = new JLabel("Father's Name:"); 
        lblfname.setBounds(50,170,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblfname);

        alblfname = new JLabel(fname);
        alblfname.setBounds(200,170,300,30);
        alblfname.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(alblfname);
        
        //4.DOB
        lbldob=new JLabel("DOB:");
        lbldob.setBounds(50,220,100,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lbldob);
        
        albldob= new JLabel(dob);
        albldob.setBounds(200,220,300,30);
        albldob.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(albldob);

        //5.Address
        lbladdress= new JLabel("Address:");
        lbladdress.setBounds(50,270,100,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lbladdress);
              
        albladdress= new JLabel(address);
        albladdress.setBounds(200,270,300,30);
        albladdress.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(albladdress);

        //6.Mobile No.
        lblphone= new JLabel("Mobile No:");  
        lblphone.setBounds(50,320,100,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblphone);

        alblphone= new JLabel(phone);
        alblphone.setBounds(200,320,300,30); 
        alblphone.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(alblphone);

        //7.Email ID
        lblemail= new JLabel("Email Id:");
        lblemail.setBounds(50,370,100,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblemail);

        alblemail= new JLabel(email);
        alblemail.setBounds(200,370,300,30);
        alblemail.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(alblemail);

        //8.Education Details
        lbledu= new JLabel("Education:");
        lbledu.setBounds(50,420,100,30);
        lbledu.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lbledu);

        albledu= new JLabel(edu);
        albledu.setBounds(200,420,300,30); 
        albledu.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(albledu);

        //9.Job Post
        lbljobpost= new JLabel("Job Post:");
        lbljobpost.setBounds(50,470,100,30);
        lbljobpost.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lbljobpost);

        albljobpost= new JLabel(jobpost);
        albljobpost.setBounds(200,470,300,30);
        albljobpost.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(albljobpost);
        
        //Button Print and Cancel
        bprint=new JButton("PRINT");
        bcancel=new JButton("CANCEL");
        
        bprint.setBackground(Color.BLACK);
        bprint.setForeground(Color.WHITE);
        bprint.setBounds(100,520,100,30);
        
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setBounds(250,520,100,30);
        
        lblimage.add(bprint);
        lblimage.add(bcancel);
        bprint.addActionListener(this);
        bcancel.addActionListener(this);      
        jf.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bprint)
        {
            jf.dispose();
            JOptionPane.showMessageDialog(null,"Details Printed Successfully");
            MainPage mp=new MainPage();        
        }
        else if(ae.getSource()==bcancel)
        {
            jf.dispose();
            View v=new View();
        }
    }
    public static void main(String[] args)
    {
        Display_Details dd=new Display_Details("Print Data");
    }
}
