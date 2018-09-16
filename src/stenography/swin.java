/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stenography;

import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.net.*;
import javax.swing.tree.*;

public class swin extends JFrame implements ActionListener,Runnable
{
	String address,form=".wav";
	Thread th;
	JTextField jf1,jf2,jf3;
	dialo jf;
	JProgressBar progressBar;
	JTextArea ja;
	int c=0,n=0,j,i=0,m=0,cou=0,tln=0,tn=1,k=0,t=0,coun=0,pb=0,thr=0,h=0,strl=0,hel=0;
	String str="",cr="",sam="";
	AudioStream as;
	InputStream ins;
	public swin()
	{
		setSize(1023,738);
		Toolkit tool = Toolkit.getDefaultToolkit();
	        Image cards = tool.getImage( "stegano.jpg" );
		setIconImage(cards);
		setTitle("Steganography");
		Container con=getContentPane();
		con.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JLabel title=new JLabel("AUDIO STEGANOGRAPHY");
		
		title.setBounds(380,30,250,25);
		Font f = new Font("SansSerif", Font.BOLD, 20);
		title.setFont(f);
		
		JLabel srcname=new JLabel("Source Name");
		srcname.setBounds(100,100,250,25);
		
		JLabel desname=new JLabel("Destn.  Name");
		desname.setBounds(100,150,250,25);
	
		jf1=new JTextField();
		jf1.setBounds(180,100,250,25);
	
		jf2=new JTextField();
		jf2.setBounds(180,150,250,25);
		
		JButton play=new JButton("Play");
		play.setBounds(570,100,100,30);
		
		
		JButton brow=new JButton("Browse");
		brow.setBounds(450,100,100,30);
		
		JLabel msg=new JLabel("Message");
		msg.setBounds(700,100,300,30);
	
		ja=new JTextArea(25,33);
		ja.setBounds(700,130,300,370);
	
		JTabbedPane jtp=new JTabbedPane();
		jtp.add("FORMATS",new format());
		jtp.setBounds(160,220,350,70);
	
		progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);
		progressBar.setBounds(240,350,250,30);
		
		JLabel pgbar=new JLabel("Progress Bar");
		pgbar.setBounds(150,350,250,25);
	
		JLabel enckey=new JLabel("  Encrypt Key");
		enckey.setBounds(150,400,250,25);
	
		jf3=new JTextField("");
		jf3.setBounds(240,400,250,25);
	
		JButton plen=new JButton("Play Encd.File");
		plen.setBounds(100,500,130,30);
	
		JButton enco=new JButton("Encode");
		enco.setBounds(250,500,130,30);
	
		JButton clear=new JButton("Clear");
		clear.setBounds(800,520,130,30);

		JButton deco=new JButton("Decode");
		deco.setBounds(400,500,130,30);
	
		JButton send=new JButton("Send");
		send.setBounds(550,500,130,30);
	
		JButton clearall=new JButton("Clear All");
		clearall.setBounds(550,560,130,30);
	
		JButton chart=new JButton("Chart");
		chart.setBounds(100,560,130,30);
	
		JButton help=new JButton("Help");
		help.setBounds(250,560,130,30);
	
		JButton stop=new JButton("Stop");
		stop.setBounds(400,560,130,30);
	

		JButton exit=new JButton("Exit");
		exit.setBounds(295,630,190,30);
		
		con.add(jf3);
		con.add(enckey);
		con.add(pgbar);
		con.add(progressBar);
		con.add(title);
		con.add(srcname);
		con.add(brow);
		con.add(jf1);
		con.add(play);
		con.add(ja);
		con.add(jf2);
		con.add(desname);
		con.add(jtp);
		con.add(plen);
		con.add(enco);
		con.add(deco);
		con.add(send);
		con.add(msg);
		con.add(exit);
		con.add(help);
		con.add(clear);
		con.add(stop);
		con.add(clearall);
		con.add(chart);
		
		brow.addActionListener(this);
		play.addActionListener(this);
		plen.addActionListener(this);
		enco.addActionListener(this);
		deco.addActionListener(this);
		send.addActionListener(this);
		exit.addActionListener(this);
		help.addActionListener(this);
		clear.addActionListener(this);
		stop.addActionListener(this);
		clearall.addActionListener(this);
		chart.addActionListener(this);
	
}




public void actionPerformed(ActionEvent ae) 
{
String st=ae.getActionCommand();
if(st.equals("Browse"))
{
	JFileChooser filechooser=new JFileChooser(JFileChooser.SELECTED_FILES_CHANGED_PROPERTY);
	File f=new File("E:\\songs");
	filechooser.setCurrentDirectory(f);
	filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	filechooser.setFileFilter(new filter());
	String se="";
	int r=filechooser.showOpenDialog(this);
	File fc=filechooser.getCurrentDirectory();
				
	File tempfilename=filechooser.getSelectedFile(); 
	
      	if(r==JFileChooser.CANCEL_OPTION)
	       JOptionPane.showMessageDialog(this,"File Not Selected","Error",JOptionPane.ERROR_MESSAGE);	
      	else
        		se=""+fc+"\\"+tempfilename.getName();
	int ind=se.indexOf('\\',3);
	
	if(ind==3)
	{
	StringBuffer sbu= new StringBuffer(se);
	sbu.deleteCharAt(ind);
	se=sbu.toString();
	}
		
	jf1.setText(se);
	
}

if(st.equals("Chart"))
{
	JDialog jf=new JDialog();
	setLayout(new BorderLayout());
	//Toolkit to = Toolkit.getDefaultToolkit();
	//ImageIcon ig=new ImageIcon("fchart.GIF");
	//Image card = ig.getImage();
	//jf.setIconImage(card);
	str=jf1.getText();
	String std=jf2.getText();
	picture jp=new picture(str,std,strl);
	jf.setTitle("Frequency Chart");
	jp.setVisible(true);
	jf.getContentPane().add(jp);
	jp.setBounds(80,100,150,200);
	jf.setBounds(80,100,150,200);
	jf.setSize(883,600);
	jf.setVisible(true);
}

if(st.equals("Stop"))
	AudioPlayer.player.stop(as);

if(st.equals("Clear All"))
{
	jf1.setText("");
	jf2.setText("");
	jf3.setText("");
}

if(st.equals("Play")) 
{
try
{
	ins=new FileInputStream(jf1.getText());
	as=new AudioStream(ins);
	AudioPlayer.player.start(as);
}
catch(Exception c)
{
JOptionPane.showMessageDialog(this,"No file is Opened","WARNING",JOptionPane.WARNING_MESSAGE);
}
}


if(st.equals("Play Encd.File"))
{
try
{
	
	ins=new FileInputStream(jf2.getText());
	as=new AudioStream(ins);
	AudioPlayer.player.start(as);
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"No file is Opened","WARNING",JOptionPane.WARNING_MESSAGE);
}
}

if(st.equals("Encode"))
{
	
	t=0;
	n=0;
	cou=0;
	c=0;
	tln=0;
	strl=ja.getText().length();
	if(jf1.getText().equals(""))
		JOptionPane.showMessageDialog(this,"Specify the source file","ERROR",JOptionPane.ERROR_MESSAGE);
	else if(jf2.getText().equals(""))
		JOptionPane.showMessageDialog(this,"Specify the destination file","ERROR",JOptionPane.ERROR_MESSAGE);
	else if(jf3.getText().equals(""))
		JOptionPane.showMessageDialog(this,"Specify encrypt key","ERROR",JOptionPane.ERROR_MESSAGE);
	else if(ja.getText().equals(""))
	JOptionPane.showMessageDialog(this,"Enter the message","ERROR",JOptionPane.ERROR_MESSAGE);

	else
	{
	try
	{
	InputStream ints=new FileInputStream(jf1.getText());
	while(c!=-1)
	{
		c=ints.read();
		if((c==254)||(c==255))
		


	t++;
		if(t==(strl*8))
		{
			t=0;
			ints.close();
			break;

		}
	}
	ints.close();

	}catch(Exception e){}
	
	if(t!=0)
	JOptionPane.showMessageDialog(this,"The Audio file size is too small to encode.Change audio file or reduce the message","ERROR",JOptionPane.ERROR_MESSAGE);
	else
	{
	t=0;
	c=0;
	BigInteger bi1,bi2;
	BigDecimal bd1;
	str=jf3.getText();
	tln=str.length();
	for(int i=0;i<tln;i++)
	{
		tn=(int)str.charAt(i);
		t=t ^ tn;
	}
	t=t>>1;	
	
	str=jf2.getText();
	strl=ja.getText().length();
	int leng=str.length();
	StringBuffer sbr=new StringBuffer(str);
	form=form.toLowerCase();
	if(str.endsWith(""))
	{}
	else if(str.endsWith("wav")||str.endsWith("mp3")||str.endsWith("aif")||str.endsWith("mid")||str.endsWith("au "))
	{
		if(str.endsWith(form)){}
		else
		{
			


			
			form="."+form;
			sbr.append(form);
			sbr.replace(leng-4,leng,form);
			str=sbr.toString();
			jf2.setText(str);
		}
	}
	else
	{
		form="."+form;
		sbr.append(form);
		str=sbr.toString();
		jf2.setText(str);
	}

	int a;
	cou=0;
	k=0;
a=JOptionPane.showConfirmDialog(this,"Do u Want To Continue With The Following Information ?","CONFIRM",JOptionPane.YES_NO_OPTION);
	if(a==0)
	{
	
	try
	{
		ins=new FileInputStream(jf1.getText());
	OutputStream outs=new FileOutputStream(jf2.getText());
	
	cr=ja.getText();
	tln=cr.length();
			
do
{
	
	while(tln!=0)
	{
		int as=(int)cr.charAt(cou);
		System.out.println(as);
		as=as+t;
		System.out.println(as);
		BigDecimal bc=new BigDecimal(as);
		BigInteger bi=bc.toBigInteger();
		String bn=bi.toString(2);
		coun=8-(bn.length());
		while(coun!=0)
	


	{
			bn="0"+""+bn;
			coun--;
		}
		
		System.out.println(bn);
	
		tn=bn.length()-1;
					
		do	
		{
			c=ins.read();
			
			if((c==255)||(c==254))
			{
				if(c!=-1)
				{
					m=0;
					BigDecimal bd=new BigDecimal(c);
				        BigInteger Bn=bd.toBigInteger();
					String slen=Bn.toString(2);
					System.out.println(c);
					System.out.println(slen);
					StringBuffer sb=new StringBuffer(slen);
					sb.deleteCharAt(sb.length()-1);
					str=sb+""+bn.charAt(tn);
					System.out.println(str);
					int len=str.length()-1;
					
					for(i=len;i>=0;i--)
					{
						k=k+1;
						Character cs=new Character(str.charAt(i));
						String sr=cs.toString();
						n=Integer.parseInt(sr);
						for(j=0;j<k;j++)
						{
							if(j!=0)
								n=n*2;
						}
			
						m=m+n;
					}
				
				}
				outs.write(m);
				
			

				tn=tn-1;
				k=0;
				
			}
			
			else
			outs.write(c);
			
		            
		}while(tn>=0);
		
		tln=tln-1;
		cou=cou+1;
	}	
		
		c=ins.read();
		if((c==254)||(c==255))
		{
		if(coun!=8)
		{
		outs.write(255);
		coun++;
		}
		else
		outs.write(c);
		}
		else
		outs.write(c);
			
	
		
}while(c!=-1);

ins.close();
outs.close();

JOptionPane.showMessageDialog(this,"The Message is successfully Encoded in the File","INFORM",JOptionPane.INFORMATION_MESSAGE);

}
catch(Exception e){
JOptionPane.showMessageDialog(this,e,"ERROR",JOptionPane.ERROR_MESSAGE);
}
}
}
}


}

if(st.equals("Decode"))
{
cou=0;
c=0;
String dis="";
n=0;
str=jf3.getText();
t=0;
tln=str.length();

for(int i=0;i<tln;i++)
{
tn=(int)str.charAt(i);
t=t ^ tn;
}
t=t>>1;	
try
{
InputStream in =new FileInputStream(jf2.getText());
while(c!=-1)
{
	cou=0;
	char ex[]=new char[8];
	
	do
	{
		c=in.read();
		
		if((c==254)||(c==255))
		{
			BigDecimal bc=new BigDecimal(c);
			BigInteger bi=bc.toBigInteger();
			cr=bi.toString(2);
			ex[cou]=cr.charAt(cr.length()-1);
			cou+=1;
									
		}
		
		}while(cou<=7);
	
	m=0;
	k=0;
	
	for(i=0;i<=7;i++)
	{
	

	k=k+1;
		Character cs=new Character(ex[i]);
		String sr=cs.toString();
		n=Integer.parseInt(sr);
		for(j=0;j<k;j++)
		{
			if(j!=0)
				n=n*2;
		}
			
			m=m+n;
	
	}
		if(m==255)	
		c=-1;
	else
	m=m-t;
	if((m!=35)&&(m<255))
		dis=dis+""+(char)m;
	
	else if(m==32)
	System.out.print(" ");
	
	else if(m==10)
	dis=dis+"";
	
	else if(m==9)
	dis=dis+"";
	
	
	
	
	
}
JOptionPane.showMessageDialog(this,"The message is successfully decoded from the file.","INFORM",JOptionPane.INFORMATION_MESSAGE);
ja.setText(dis);
in.close();
}

catch(Exception e)
{
JOptionPane.showMessageDialog(this,"There was an error in decoding.Please check again","ERROR",JOptionPane.ERROR_MESSAGE);
}
}
if(st.equals("Send"))


{
str=jf2.getText();
if(str.equals(""))
JOptionPane.showMessageDialog(this,"Mention the file name","INFORM",JOptionPane.INFORMATION_MESSAGE);
else
{
cou=0;
	try
	{
	address=JOptionPane.showInputDialog("Enter IP Address");
	InetAddress ipaddress=InetAddress.getByName(address);
	if(address!=null)
	{
        Socket socket=new Socket(ipaddress,6000);
        OutputStream out=socket.getOutputStream();
        InputStream in=new FileInputStream(jf2.getText());
	while(true)
         {
          int i=in.read();
          if(i==-1) break;
          out.write(i);
	  cou++;
		
         }
         in.close();
         out.close();
	}
if(address.equals(""))
{}
else
JOptionPane.showMessageDialog(this,"The Message was successfully sent","INFORM",JOptionPane.INFORMATION_MESSAGE);

	}
	catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Sorry the message was not sent.Try again","ERROR",JOptionPane.ERROR_MESSAGE);
}
}
System.out.println(cou);
}
if(st.equals("Exit"))
{
	System.exit(0);
}



if(st.equals("Help"))
{
	jf=new dialo();
	Toolkit	to = Toolkit.getDefaultToolkit();
	ImageIcon ig=new ImageIcon("help.GIF");
	Image card = ig.getImage();
	//jf.setImageIcon(card);
	
	jf.setTitle("HELP");
	jf.setBounds(80,100,150,200);
	jf.setSize(548,472);
	jf.setVisible(true);
	
}

if(st.equals("Clear"))
	ja.setText(" ");

}

public void run()
{
try
{
	Thread.sleep(1500);
	progressBar.setValue(h);
	System.out.println(h);
}

catch(Exception e){}
}

public static void main(String[] args)
{
	swin sf = new swin();
       	sf.show();

}

class format extends JPanel implements ActionListener
{
public format()
{
ButtonGroup bg=new ButtonGroup();
JRadioButton jr1=new JRadioButton("WAV ",true);
bg.add(jr1);


JRadioButton jr2=new JRadioButton("MP3 ");
bg.add(jr2);
JRadioButton jr3=new JRadioButton("MID ");
bg.add(jr3);
JRadioButton jr4=new JRadioButton("AIFF");
bg.add(jr4);
JRadioButton jr5=new JRadioButton("AU  ");
bg.add(jr5);

add(jr1);
add(jr2);
add(jr3);
add(jr4);
add(jr5);

jr1.addActionListener(this);
jr2.addActionListener(this);
jr3.addActionListener(this);
jr4.addActionListener(this);
jr5.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
String str=jf2.getText();
form=ae.getActionCommand();
int len;
StringBuffer suf=new StringBuffer(jf2.getText());
len=suf.length();

if(len!=0)
{
if(str.endsWith("wav ")||str.endsWith("mp3 ")||str.endsWith("aiff")||str.endsWith("mid ")||str.endsWith("au  "))
{

if(form.equals("WAV "))
suf.replace(len-4,len,"wav ");

if(form.equals("MP3 "))
suf.replace(len-4,len,"mp3 ");

if(form.equals("AIFF"))
suf.replace(len-4,len,"aiff");

if(form.equals("MID "))
suf.replace(len-4,len,"mid ");



if(form.equals("AU  "))
suf.replace(len-4,len,"au  ");

String st=suf.toString();
jf2.setText(st);

}
else
jf2.setText(str+"."+form.toLowerCase());
}
}

}
class tab extends JPanel implements MouseListener
{
JTree tree;
Image img;
public tab()
{
	DefaultMutableTreeNode top=new DefaultMutableTreeNode("  Introduction to steganography");
	DefaultMutableTreeNode intro=new DefaultMutableTreeNode("what is steganography");
	top.add(intro);
	DefaultMutableTreeNode intro1=new DefaultMutableTreeNode("How it works");
	top.add(intro1);
	DefaultMutableTreeNode chara=new DefaultMutableTreeNode("Characteristics        ");
	top.add(chara);
	DefaultMutableTreeNode srcdes=new DefaultMutableTreeNode("Selecting Audio");
	chara.add(srcdes);
	DefaultMutableTreeNode plysun=new DefaultMutableTreeNode("How to Play");
	chara.add(plysun);
	DefaultMutableTreeNode entex=new DefaultMutableTreeNode("Entering Message");
	chara.add(entex);
	DefaultMutableTreeNode encdec=new DefaultMutableTreeNode("Encrypt and Decrypt");
	chara.add(encdec);
	DefaultMutableTreeNode audfor=new DefaultMutableTreeNode("Audio Formats");
	chara.add(audfor);
	DefaultMutableTreeNode send=new DefaultMutableTreeNode("Sending File");
	

	chara.add(send);
	DefaultMutableTreeNode frqch=new DefaultMutableTreeNode("Frequency Chart");
	chara.add(frqch);
	DefaultMutableTreeNode clrtex=new DefaultMutableTreeNode("Clearing Text");
	chara.add(clrtex);
	DefaultMutableTreeNode misc=new DefaultMutableTreeNode("Miscellaeneous");
	DefaultMutableTreeNode version=new DefaultMutableTreeNode("Version");
	misc.add(version);
	DefaultMutableTreeNode lisc=new DefaultMutableTreeNode("License");
	misc.add(lisc);
	DefaultMutableTreeNode about=new DefaultMutableTreeNode("About");
	top.add(misc);
	top.add(about);
	tree=new JTree(top);
	add(tree);
	tree.addMouseListener(this);  
}
public void mouseClicked(MouseEvent me)
{
try
{
TreePath tp=tree.getSelectionPath();
hel=tree.getRowForPath(tp);
help hp=null;
//jf.remove(hp);
hp=new help();
jf.add(hp,BorderLayout.CENTER);
}catch(Exception e){}
}
public void mouseExited(MouseEvent me){}

public void mouseEntered(MouseEvent me){}
public void mouseReleased(MouseEvent me){}

public void mousePressed(MouseEvent me){}

}
class help extends JPanel
{
Container con;
Image img;
ImageIcon ig;

public help()


{
System.out.println(hel);
if(hel==0)
ig=new ImageIcon("intro1.GIF");
else if(hel==1)
ig=new ImageIcon("intro.GIF");
else if(hel==2)
ig=new ImageIcon("works.GIF");
else if(hel==3)
ig=new ImageIcon("charac.GIF");
else if(hel==4)
ig=new ImageIcon("select.GIF");
else if(hel==5)
ig=new ImageIcon("play.GIF");
else if(hel==6)
ig=new ImageIcon("entermsg.GIF");
else if(hel==7)
ig=new ImageIcon("encdec.GIF");
else if(hel==8)
ig=new ImageIcon("auformats.GIF");
else if(hel==9)
ig=new ImageIcon("send.GIF");
else if(hel==11)
ig=new ImageIcon("clear.GIF");
else if(hel==12)
ig=new ImageIcon("miscl.GIF");
else if(hel==13)
ig=new ImageIcon("version.GIF");
else
ig=null;
img=ig.getImage();
hel=0;
repaint();	
}
public void paintComponent(Graphics g)
{
super.paintComponent(g);
g.drawImage(img,0,0,this);
}
}

class dialo extends JDialog implements ActionListener
{
JTextArea jt;
String as;
Container con;
public dialo()


{
	con=getContentPane();
	con.setLayout(new BorderLayout());
	JTabbedPane jtb=new JTabbedPane();
	jtb.addTab("Help",new tab());
	jtb.setVisible(true);
	//jtb.setSize(200,400);
	add(jtb,BorderLayout.WEST);
	JMenuBar jm=new JMenuBar();
	JMenu jm1=new JMenu("File");
	JMenuItem ji=new JMenuItem("Exit");
	jm1.add(ji);
	jm.add(jm1);
	add(jm,BorderLayout.NORTH);
	ji.addActionListener(this);
	//help hp=new help();
	//hp.setVisible(true);
	//hp.setBounds(80,80,80,80);
	//con.add(hp,BorderLayout.CENTER);
	
	
}

public void actionPerformed(ActionEvent ae)
{
setVisible(false);
}
}
}

class filter extends javax.swing.filechooser.FileFilter
{
public boolean accept(File f)
{
return f.isDirectory() || f.getName().toLowerCase().endsWith(".mp3")||f.getName().toLowerCase().endsWith(".wav")||f.getName().toLowerCase().endsWith(".mid")
||f.getName().toLowerCase().endsWith(".au")||f.getName().toLowerCase().endsWith(".aiff");
}

public String getDescription()
{
        return "All Audio Songs";
}


}
class picture extends JPanel
{
Image img;
int leng,len,lenl;
String sto,std;
public picture(String str,String stri,int lenh)
{
setLayout(new BorderLayout());
sto=str;
std=stri;
System.out.println(lenh);
leng=lenh*8;
lenl=lenh*8;;
ImageIcon ig=new ImageIcon("chart.GIF");
img=ig.getImage();
repaint();

}

public void paintComponent(Graphics g)
{
super.paintComponent (g);
g.drawImage(img,0,0,this);
int c=0,i=0,x=0,y=0,x1=0,y1=0,j=0,n=0,u=0,k1=0;
float k=0;
i=50;
try
{
k1=780/(lenl/8);
}catch(Exception e){}
if(((lenl/8)>360)&& ((lenl/8)<440))
k1=2;
u=0;
try
{
leng=lenl;
InputStream in= new FileInputStream(sto);

while(c!=-1)
{
	if(leng>=0)
	{
		c=in.read();
				
		
	
	if((u>7)&&((c==254)||(c==255)))
		{
			u=0;
			k=(float)n/8;
			n=c;
			if(k>254.5)
			c=255;
			else
			c=254;
						
			if(c==254)
			{
				j++;
				g.setColor(Color.red);
				g.drawString("."+j,i,214);
				x=i;
				y=214;
				if(j==1)
				{
					x1=x;
					y1=y;
					//g.drawString("."+j,i,435);
				}
				g.setColor(Color.cyan);
				g.drawLine(x1,y1,x,y);
				
				i=i+k1;
				leng--;
			}
			else if(c==255)
			{
				j++;
			
				g.setColor(Color.red);
				g.drawString("."+j,i,98);
				x=i;
				y=98;
				if(j==1)
				{
					x1=x;
					y1=y;
				}
				g.setColor(Color.cyan);
				g.drawLine(x1,y1,x,y);
				leng--;
				
				i=i+k1;
		

	}
		x1=x;
		y1=y;
		c=0;	
		n=n+c;
		u++;
		}
		else if((c==255)||(c==254))
		{
		n=n+c;
		u++;
		leng--;
		}
		}
	else
	c=-1;
	
}
	in.close();
}catch(Exception e){}
j=0;
i=50;
c=0;
u=0;
n=0;
try
{
len=lenl;	
	InputStream ins=new FileInputStream(std);
	while(c!=-1)
	{
		if(len>=0)
		{
			c=ins.read();
				if((u>7)&&((c==254)||(c==255)))
				{
				u=0;
				k=(float)n/8;
				n=c;
				if(k>254.5)
				c=255;
				else
				c=254;
				if(c==254)
				{
					j++;
					

					g.setColor(Color.red);
					g.drawString("."+j,i,465);
					x=i;
					y=465;
						if(j==1)
						{
							x1=x;
							y1=y;
							
						}
					g.setColor(Color.cyan);
					g.drawLine(x1,y1,x,y);
					i=i+k1;
					len--;
									
				}
				else if(c==255)
				{
					j++;
					g.setColor(Color.red);
					g.drawString("."+j,i,352);
					x=i;
					y=352;
						if(j==1)
							{
								x1=x;
								y1=y;
							}
					g.setColor(Color.cyan);
					g.drawLine(x1,y1,x,y);
					i=i+k1;
					len--;
					}
				x1=x;
				y1=y;
				c=0;
				n=n+c;
				u++;
				}
				else if((c==255)||(c==254))
				{
					n=n+c;
					u++;
					len--;
				}
				}
		else
			c=-1;
	}	
}catch(Exception e){}
}}
