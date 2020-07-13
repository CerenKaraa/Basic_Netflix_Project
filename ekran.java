import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Date;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ekran extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane1;
	private JPanel contentPane2;
	private JPanel contentPane3;
	private JPanel contentPane4,contentPane5,contentPane6,contentPane7;
	private JTextField textField_1,textField_2,textField,txtDdmmyy,txtAramakIstediinizFilm,textField_3;
	private JTextField mail;
	private JTextField sifre;
	private Timer timer;
	private JSlider slider;
	private JButton button;
	int saat,dakika,saniye,k,y1=0,x1=0,y2=0;
	String tur=null;
	static String sqlpass;
	static int sayýd=0,kontrolýd=0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ekran frame = new ekran();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	protected void startTheClock() {
        timer.start();
        timer.setDelay(1000);
        button.setText("||");
    }

    protected void stopTheClock() {
        timer.stop();
        button.setText(">");
    }
	public Color randomColor() {
		Random rand = new Random();
		float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = 0.8f + ((1f - 0.8f) * rand.nextFloat());
		Color randomColor = new Color(r, g, b);
		return randomColor;
	}
	void puanbul(String filmadi,double puan) {
		ResultSet myRs=null;
		String sql1;
		String sql="select *from program where Ad='"+filmadi+"'";
		myRs=dB.sorgula(sql);
		double orjpuan=0;
		int kisi=0;
		try {
			while(myRs.next()) {
				orjpuan=myRs.getDouble("Puan");
				kisi=myRs.getInt("PuanSayisi");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		kisi++;
		orjpuan=((orjpuan*(kisi-1))+puan)/kisi;
		sql1="UPDATE program SET Puan='"+orjpuan+"',PuanSayisi='"+
		kisi+"' WHERE Ad='"+filmadi+"'";
		dB.update(sql1);
	}
	static int kontrol=0,sayt=0,sayb=0;
	static String kullanici=null;
	static int girdi=0,labelsay=0,x=0,y=0,labelsay1=0;
	private Scanner scn;
	void arayuz() {
		JLabel[] label = new JLabel[100];
		contentPane4=new JPanel();
		contentPane4.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane4);
		contentPane4.setLayout(null);
		contentPane4.setBounds(0,0,1055,614);
		
		txtAramakIstediinizFilm = new JTextField();
		txtAramakIstediinizFilm.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(sayb==0) {
				txtAramakIstediinizFilm.setText("");
				sayb++; }
			}
		});
		txtAramakIstediinizFilm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				txtAramakIstediinizFilm.setText("");
			}
		});
		txtAramakIstediinizFilm.setHorizontalAlignment(SwingConstants.CENTER);
		txtAramakIstediinizFilm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAramakIstediinizFilm.setText("Aramak Ýstediðiniz Film Adi veya Türü");
		txtAramakIstediinizFilm.setBounds(562, 0, 380, 28);
		contentPane4.add(txtAramakIstediinizFilm);
		txtAramakIstediinizFilm.setColumns(10);
		MouseListener m = new MouseAdapter() 
	    {
			public void mouseClicked(MouseEvent e) {
				dizibilgi(e.getComponent().getName());
			}
		};
		
		JLabel lblNewLabel_2 = new JLabel("Hata Yazdir");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(643, 37, 270, 28);
		contentPane4.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Hen\u00FCz hi\u00E7bir \u015Fey izlemediniz");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(209, 137, 286, 37);
		contentPane4.add(lblNewLabel_1);
		
		ResultSet myRs=null;
		String sql="SELECT *FROM kullaniciprogram WHERE mail='"+kullanici+"'";
		
		myRs=dB.sorgula(sql);
		int labelsay1=0;
		try {
			while(myRs.next()) {
				lblNewLabel_1.setVisible(false);
				label[labelsay1]=new JLabel("");
				label[labelsay1].setText(myRs.getString("filmadi"));
				label[labelsay1].setName(myRs.getString("filmadi"));
				label[labelsay1].setHorizontalAlignment(SwingConstants.CENTER);
				label[labelsay1].setOpaque(true); 
				label[labelsay1].setBackground(randomColor());
				label[labelsay1].setFont(new Font("Tahoma", Font.PLAIN, 16));
				label[labelsay1].setBounds(101+x1,137+y2,242,53);
				contentPane4.add(label[labelsay1]);
				label[labelsay1].addMouseListener(m);
				labelsay1++;
				if(labelsay1%3==0) {
					y2+=87; x1=0; }
				else { x1+=283; }
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		x1=0; y2=0;
		
		JButton btnNewButton = new JButton("Ara");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(txtAramakIstediinizFilm.getText().equals("") || txtAramakIstediinizFilm.getText().equals(" ")) {
					lblNewLabel_2.setText("Arama Ekraný Boþ Geçilemez");
					lblNewLabel_2.setVisible(true);
				}
				else {
					lblNewLabel_2.setVisible(false);
					String ara=txtAramakIstediinizFilm.getText();
					labelsay=0;
					araekrani(ara);
				}
			}
		});
		btnNewButton.setBounds(940, 0, 97, 28);
		contentPane4.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(kullanici+" izlemeye devam et:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(49, 96, 294, 28);
		contentPane4.add(lblNewLabel);
		
		
	}
	void izlemeekrani(String tur,String program,String bolum) {
		contentPane6=new JPanel();
		contentPane6.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane6);
		contentPane6.setLayout(null);
		contentPane6.setBounds(0,0,1055,614);
		slider = new JSlider();
		if(tur.equals("Film")) {
		slider.setMaximum(7200);
		}
		if(tur.equals("Dizi")) {
			slider.setMaximum(3600);
		}
		if(tur.equals("Tv Show")) {
			slider.setMaximum(10800);
		}
		slider.setPaintTicks(true);
		slider.setBounds(99, 549, 938, 18);
		contentPane6.add(slider);
		Date simdikiZaman = new Date();
		int sure = 0;
		int bolumi=Integer.valueOf(bolum);  
		try {
			ResultSet myRs=dB.yapF();
			while(myRs.next()) {
				kontrolýd=0;
				sayýd=myRs.getInt("Izleýd");
				if(kullanici.equals(myRs.getString("mail"))){
					kontrolýd=1;
					if(kontrolýd==1 && program.equals(myRs.getString("filmadi"))) {
						kontrolýd=2; 
						if(bolumi!=myRs.getInt("bölüm")) {
							sure=0;
							String sql1="UPDATE kullaniciprogram SET bölüm="+bolumi+" WHERE filmadi='"+program+"' AND mail='"+kullanici+"'";
				            dB.update(sql1);
				            String sql2="UPDATE kullaniciprogram SET tarih='"+simdikiZaman.toString()+"' WHERE filmadi='"+program+"' AND mail='"+kullanici+"'";
				            dB.update(sql2);
						}
						else {
							sure=myRs.getInt("süre");
							String sql2="UPDATE kullaniciprogram SET tarih='"+simdikiZaman.toString()+"' WHERE filmadi='"+program+"' AND mail='"+kullanici+"'";
				            dB.update(sql2);
						}
			            break;
					}
				}
			}
		if(kontrolýd==1) {
			sayýd++;
			String sql;
			sql="INSERT INTO kullaniciprogram (Izleýd,mail,filmadi,süre) VALUES ('" +sayýd+"','"+kullanici+"','"+program +"',"+0+")";
			sure=0;
			dB.ekle(sql);
			String sql1="UPDATE kullaniciprogram SET bölüm="+bolum+" WHERE filmadi='"+program+"' AND mail='"+kullanici+"'";
            dB.update(sql1);
            String sql2="UPDATE kullaniciprogram SET tarih='"+simdikiZaman.toString()+"' WHERE filmadi='"+program+"' AND mail='"+kullanici+"'";
            dB.update(sql2);
		}
		if(kontrolýd!=1 && kontrolýd!=2){ 
			sayýd++;
			String sql;
			sql="INSERT INTO kullaniciprogram (Izleýd,mail,filmadi,süre) VALUES ('" +sayýd+"','"+kullanici+"','"+program +"',"+0+")";
			sure=0;
			dB.ekle(sql);
			String sql1="UPDATE kullaniciprogram SET bölüm="+bolum+" WHERE filmadi='"+program+"' AND mail='"+kullanici+"'";
            dB.update(sql1);
            String sql2="UPDATE kullaniciprogram SET tarih='"+simdikiZaman.toString()+"' WHERE filmadi='"+program+"' AND mail='"+kullanici+"'";
            dB.update(sql2);
	   }
		}catch(Exception e1) {
			System.out.println(e1);
		}
		slider.setValue(sure);
		JLabel lbl = new JLabel("New label");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 70));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(230, 124, 562, 273);
		contentPane6.add(lbl);
		int d=sure/60;
		int sy=sure%60;
		int s=d/60;
		d=d%60;
		lbl.setText(s+"."+d+"."+sy);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				saniye=slider.getValue();
				dakika = saniye / 60; 
				 saniye = saniye % 60; 
				 saat = dakika / 60 ;  
				 dakika = dakika % 60; 
				lbl.setText(Integer.toString(saat)+"."+Integer.toString(dakika)+"."+Integer.toString(saniye));
			}
        });
        button = new JButton(">");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                	String sql1="UPDATE kullaniciprogram SET süre="+slider.getValue()+
                         " WHERE filmadi='"+program+"' AND mail='"+kullanici+"'";
                          dB.update(sql1);
                    stopTheClock();
                } else {
                    startTheClock();
                }
            }
        });
        timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = slider.getValue() + 1;
                if (value >= slider.getMaximum()) {
                    stopTheClock();
                } else {
                    slider.setValue(value);
                }
            }
        });
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(0, 542, 97, 25);
		contentPane6.add(button);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				stopTheClock();
				arayuz();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(0, 0, 118, 37);
		contentPane6.add(btnNewButton);
	}
	void dizibilgi(String program) {
		JLabel[] label = new JLabel[100];
		contentPane7=new JPanel();
		contentPane7.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane7);
		contentPane7.setLayout(null);
		contentPane7.setBounds(0,0,1055,614);
		
		JLabel lblNewLabel = new JLabel("Film adý");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(55, 69, 358, 56);
		contentPane7.add(lblNewLabel);
		lblNewLabel.setText(program);
		
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
		panel.setLayout(null);
		panel.setBounds(91,211,268,300);
		panel.setPreferredSize(new Dimension(300,2000));
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(91,211,268,300);
		contentPane7.add(scrollPane);
		
		JLabel lblNewLabel_4 = new JLabel("x/10");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(647, 216, 56, 16);
		contentPane7.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("En son izlediðiniz bölüm:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(516, 35, 210, 32);
		contentPane7.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setText("x. Bölüm");
		lblNewLabel_6.setOpaque(true); 
		lblNewLabel_6.setBackground(SystemColor.activeCaption);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(626, 69, 285, 43);
		contentPane7.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		ResultSet myRs=null;
		
		String sql="SELECT *FROM program WHERE Ad='"+program+"'";
		
		myRs=dB.sorgula(sql);
		try {
			while(myRs.next()) {
				tur=myRs.getString("Tip");
				if(myRs.getString("Tip").equals("Film")) {
					label[1]=new JLabel("");
					labelsay1=myRs.getInt("Bolum");
					lblNewLabel_4.setText(myRs.getInt("Puan")+"/10");
					label[1].setName("1");
					label[1].setText("1. Bölüm");
					label[1].setOpaque(true); 
					label[1].setBackground(SystemColor.activeCaption);
					label[1].setFont(new Font("Tahoma", Font.PLAIN, 16));
					label[1].setBounds(0,0,258,25);
					panel.add(label[1]);
			 }
				else {
					int sayi=myRs.getInt("Bolum");
					labelsay1=myRs.getInt("Bolum");
					lblNewLabel_4.setText(myRs.getInt("Puan")+"/10");
					for(int i=1;i<sayi+1;i++) {
						label[i]=new JLabel(" ");
						label[i].setName(i+"");
						label[i].setText(i+". Bölüm");
						label[i].setOpaque(true); 
						label[i].setBackground(SystemColor.activeCaption);
						label[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
						label[i].setBounds(0,0+y1,258,25);
						panel.add(label[i]);
						y1+=27;
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet myRs2=null;
		String sql2="SELECT *FROM kullaniciprogram WHERE mail='"+kullanici+"' AND filmadi='"+program+"'";
		
		myRs2=dB.sorgula(sql2);
		try {
			while(myRs2.next()) {
				lblNewLabel_5.setVisible(true);
				lblNewLabel_6.setText(myRs2.getInt("bölüm")+". Bölüm");
				lblNewLabel_6.setName(myRs2.getInt("bölüm")+"");
				lblNewLabel_6.setVisible(true);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		MouseListener m = new MouseAdapter() 
	    {
			public void mouseClicked(MouseEvent e) {
				izlemeekrani(tur,lblNewLabel.getText(),e.getComponent().getName());
			}
		};
		for(int j=1;j<labelsay1+1;j++) {
			label[j].addMouseListener(m);
		}
		lblNewLabel_6.addMouseListener(m);
		labelsay1=0;
		y1=0;
		
		JLabel lblNewLabel_1 = new JLabel("Bölümler");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(84, 166, 275, 32);
		contentPane7.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Puan:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(576, 208, 59, 32);
		contentPane7.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(643, 251, 53, 22);
		contentPane7.add(comboBox);
		comboBox.setVisible(true);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JLabel lblNewLabel_3 = new JLabel("Puan ver:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(545, 253, 86, 16);
		contentPane7.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				arayuz();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(0, 0, 115, 49);
		contentPane7.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Puanýnýz baþarýyla gönderildi");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setBounds(818, 252, 192, 22);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		JButton btnG = new JButton("Gönder");
		btnG.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel_7.setVisible(true);
				String puan=comboBox.getSelectedItem().toString();
				double puan1=(double)Integer.valueOf(puan);
				int puan2=Integer.valueOf(puan);
				String sql1="UPDATE kullaniciprogram SET puan="+puan2+" WHERE filmadi='"+program+"' AND mail='"+kullanici+"'";
                dB.update(sql1);
				puanbul(lblNewLabel.getText(),puan1);
			}
		});
		btnG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnG.setBounds(708, 251, 92, 22);
		contentPane7.add(btnG);
		
	}
	void araekrani(String ara) {
		JLabel[] label = new JLabel[100];
		contentPane5=new JPanel();
		contentPane5.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane5);
		contentPane5.setLayout(null);
		contentPane5.setBounds(0,0,1055,614);
	
		JButton btnNewButton = new JButton("<-");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setContentPane(contentPane4);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnNewButton.setBounds(0, 0, 115, 49);
		contentPane5.add(btnNewButton);
		
		JLabel sonuc = new JLabel("Arama_Adi için sonuçlar:");
		sonuc.setFont(new Font("Tahoma", Font.BOLD, 18));
		sonuc.setBounds(74, 62, 351, 27);
		contentPane5.add(sonuc);
		
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
		panel.setLayout(null);
		panel.setBounds(0,102,1037,452);
		panel.setPreferredSize(new Dimension(2000,2000));
		
		JLabel lblNewLabel = new JLabel("Aradýðýnýz sonuç bulunamamýþtýr");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(120, 13, 302, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		ResultSet myRs=null;
		String sql="SELECT *FROM program,tür,türprogram WHERE tür.türAdi='"+ara+"'AND tür.türID=türprogram.TürID AND program.FilmId=türprogram.FilmId";
		myRs=dB.sorgula(sql);
		try {
			while(myRs.next()) {
				lblNewLabel.setVisible(false);
				label[labelsay]=new JLabel(myRs.getString("program.Ad"));
				label[labelsay].setName(myRs.getString("program.Ad"));
				label[labelsay].setOpaque(true); 
				label[labelsay].setBackground(randomColor());
				label[labelsay].setFont(new Font("Tahoma", Font.PLAIN, 16));
				label[labelsay].setHorizontalAlignment(SwingConstants.CENTER);
				label[labelsay].setBounds(40+x,13+y,288,56);
				panel.add(label[labelsay]);
				labelsay++;
				if(labelsay%3==0) {
					y+=103; x=0; }
				else { x+=329; }
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		ResultSet myRs1=null;
		String sql1="SELECT *FROM program WHERE Ad='"+ara+"'";
		myRs1=dB.sorgula(sql1);
		try {
			while(myRs1.next()) {
				lblNewLabel.setVisible(false);
				label[labelsay]=new JLabel(myRs1.getString("program.Ad"));
				label[labelsay].setName(myRs1.getString("program.Ad"));
				label[labelsay].setOpaque(true); 
				label[labelsay].setBackground(randomColor());
				label[labelsay].setFont(new Font("Tahoma", Font.PLAIN, 16));
				label[labelsay].setHorizontalAlignment(SwingConstants.CENTER);
				label[labelsay].setBounds(40+x,13+y,288,56);
				panel.add(label[labelsay]);
				labelsay++;
				if(labelsay%3==0) {
					y+=103; x=0; }
				else { x+=329; }
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		MouseListener m = new MouseAdapter() 
	    {
			public void mouseClicked(MouseEvent e) {
				dizibilgi(e.getComponent().getName());
			}
		};
		for(int i=0;i<labelsay;i++) {
			label[i].addMouseListener(m);
		}
		if(labelsay==0)
			lblNewLabel.setVisible(true);
		sonuc.setText(ara+" için sonuçlar:");
		labelsay=0;
		x=0; y=0;
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0,102,1037,452);
		contentPane5.add(scrollPane);
		
	}
	
	void filmoneri(ArrayList secilenler) {
		contentPane3 = new JPanel();
		contentPane3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane3);
		contentPane3.setLayout(null);
		contentPane3.setBounds(0,0,1055,614);
		
		JLabel lblNewLabel = new JLabel("Hoþunuza Gidebilecek Bazý Yapýmlar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(158, 13, 303, 20);
		contentPane3.add(lblNewLabel);
		
		JLabel lblTur = new JLabel("Tur1 turundeki yap\u0131mlar:");
		lblTur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTur.setHorizontalAlignment(SwingConstants.CENTER);
		lblTur.setBounds(29, 63,432, 20);
		contentPane3.add(lblTur);
		
		JLabel Film11 = new JLabel("Film1_1ad");
		Film11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Film11.setOpaque(true); 
		Film11.setBackground(randomColor());
		Film11.setHorizontalAlignment(SwingConstants.CENTER);
		Film11.setBounds(39, 96, 216, 87);
		contentPane3.add(Film11);
		
		JLabel lblTur2 = new JLabel("Tur2 turundeki yap\u0131mlar:");
		lblTur2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTur2.setBounds(555, 63,432,20);
		contentPane3.add(lblTur2);
		
		JLabel lblTur3 = new JLabel("Tur3 turundeki yap\u0131mlar:");
		lblTur3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTur3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTur3.setBounds(29, 280,432,20);
		contentPane3.add(lblTur3);
		
		JLabel Film12 = new JLabel("Film1_2 ad");
		Film12.setHorizontalAlignment(SwingConstants.CENTER);
		Film12.setOpaque(true); 
		Film12.setBackground(randomColor());
		Film12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Film12.setBounds(282, 96, 216, 87);
		contentPane3.add(Film12);
		
		JLabel Film22 = new JLabel("Film2_2ad");
		Film22.setHorizontalAlignment(SwingConstants.CENTER);
		Film22.setOpaque(true); 
		Film22.setBackground(randomColor());
		Film22.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Film22.setBounds(789, 96, 216, 87);
		contentPane3.add(Film22);
		
		JLabel Film21 = new JLabel("Film2_1ad");
		Film21.setHorizontalAlignment(SwingConstants.CENTER);
		Film21.setOpaque(true); 
		Film21.setBackground(randomColor());
		Film21.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Film21.setBounds(542, 96, 216, 87);
		contentPane3.add(Film21);
		
		JLabel Film32 = new JLabel("Film3_2ad");
		Film32.setHorizontalAlignment(SwingConstants.CENTER);
		Film32.setOpaque(true); 
		Film32.setBackground(randomColor());
		Film32.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Film32.setBounds(282, 318, 216, 87);
		contentPane3.add(Film32);
		
		JLabel Film31 = new JLabel("Film3_1ad");
		Film31.setHorizontalAlignment(SwingConstants.CENTER);
		Film31.setOpaque(true); 
		Film31.setBackground(randomColor());
		Film31.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Film31.setBounds(39, 318, 216, 87);
		contentPane3.add(Film31);
		
		JButton izle11 = new JButton("Ýzle");
		izle11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dizibilgi(Film11.getText());
			}
		});
		izle11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		izle11.setBounds(98, 196, 97, 25);
		contentPane3.add(izle11);
		
		JButton izle12 = new JButton("Ýzle");
		izle12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dizibilgi(Film12.getText());
			}
		});
		izle12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		izle12.setBounds(345, 196, 97, 25);
		contentPane3.add(izle12);
		
		JButton izle21 = new JButton("Ýzle");
		izle21.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dizibilgi(Film21.getText());
			}
		});
		izle21.setFont(new Font("Tahoma", Font.PLAIN, 16));
		izle21.setBounds(609, 196, 97, 25);
		contentPane3.add(izle21);
		
		JButton izle22 = new JButton("Ýzle");
		izle22.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dizibilgi(Film22.getText());
			}
		});
		izle22.setFont(new Font("Tahoma", Font.PLAIN, 16));
		izle22.setBounds(860, 196, 97, 25);
		contentPane3.add(izle22);
		
		JButton izle31 = new JButton("Ýzle");
		izle31.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dizibilgi(Film31.getText());
			}
		});
		izle31.setFont(new Font("Tahoma", Font.PLAIN, 16));
		izle31.setBounds(98, 418, 97, 25);
		contentPane3.add(izle31);
		
		JButton izle32 = new JButton("Ýzle");
		izle32.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dizibilgi(Film32.getText());
			}
		});
		izle32.setFont(new Font("Tahoma", Font.PLAIN, 16));
		izle32.setBounds(345, 418, 97, 25);
		contentPane3.add(izle32);
		
		JButton anasayfa = new JButton("Ana Sayfaya Don");
		anasayfa.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				arayuz();
			}
		});
		anasayfa.setFont(new Font("Tahoma", Font.BOLD, 16));
		anasayfa.setBounds(710, 479, 190, 46);
		contentPane3.add(anasayfa);
		
		lblTur.setText(secilenler.get(0)+" turundeki yapýmlar");
		lblTur2.setText(secilenler.get(1)+" turundeki yapýmlar");
		lblTur3.setText(secilenler.get(2)+" turundeki yapýmlar");
		
		ResultSet myRs1=null;
		String sql1="SELECT *FROM program,tür,türprogram WHERE tür.türAdi='"+secilenler.get(0)+"' AND tür.türID=türprogram.TürID AND program.FilmId=türprogram.FilmId ORDER BY program.puan DESC LIMIT 2";
		
		myRs1=dB.sorgula(sql1);
		int say=0;
		try {
			while(myRs1.next()) {
				if(say==0)
				Film11.setText(myRs1.getString("program.Ad"));
				if(say==1)
				Film12.setText(myRs1.getString("program.Ad"));
				say++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		say=0;
		
		sql1=sql1="SELECT *FROM program,tür,türprogram WHERE tür.türAdi='"+secilenler.get(1)+"' AND tür.türID=türprogram.TürID AND program.FilmId=türprogram.FilmId ORDER BY program.puan DESC LIMIT 2";
		
		myRs1=dB.sorgula(sql1);
		try {
			while(myRs1.next()) {
				if(say==0)
				Film21.setText(myRs1.getString("program.Ad"));
				if(say==1)
				Film22.setText(myRs1.getString("program.Ad"));
				say++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		sql1=sql1="SELECT *FROM program,tür,türprogram WHERE tür.türAdi='"+secilenler.get(2)+"' AND tür.türID=türprogram.TürID AND program.FilmId=türprogram.FilmId ORDER BY program.puan DESC LIMIT 2";
		say=0;
		myRs1=dB.sorgula(sql1);
		try {
			while(myRs1.next()) {
				if(say==0)
				Film31.setText(myRs1.getString("program.Ad"));
				if(say==1)
				Film32.setText(myRs1.getString("program.Ad"));
				say++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	void tursecim() {
		ArrayList<String> secilenler = new ArrayList<String>();
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(null);
		contentPane2.setBounds(0,0,1055,614);
		JLabel lblNewLabel = new JLabel("Hoþunuza giden yapým türlerinden 3 tanesini seçin:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(299, 0, 419, 31);
		contentPane2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hata Yazdir");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(279, 478, 439, 31);
		contentPane2.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JToggleButton secenek1 = new JToggleButton("Aksiyon ve Macera");
		secenek1.setHorizontalAlignment(SwingConstants.LEFT);
		secenek1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek1.isSelected()) {
					secilenler.add(secenek1.getText());
				}
				else {
					secilenler.remove(secenek1.getText());
				}
			}
		});
		secenek1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		secenek1.setBackground(SystemColor.activeCaption);
		secenek1.setBounds(206, 58, 137, 81);
		contentPane2.add(secenek1);
		
		JToggleButton secenek2 = new JToggleButton("Bilim Kurgu ve Fantastik Yapýmlar");
		secenek2.setForeground(new Color(255, 255, 255));
		secenek2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek2.isSelected()) {
					secilenler.add(secenek2.getText());
				}
				else {
					secilenler.remove(secenek2.getText());
				}
			}
		});
		secenek2.setBackground(new Color(0, 102, 204));
		secenek2.setFont(new Font("Myanmar Text", Font.BOLD, 9));
		secenek2.setBounds(698, 58, 147, 81);
		contentPane2.add(secenek2);
		
		JToggleButton secenek3 = new JToggleButton("Romantik");
		secenek3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek3.isSelected()) {
					secilenler.add(secenek3.getText());
				}
				else {
					secilenler.remove(secenek3.getText());
				}
			}
		});
		secenek3.setFont(new Font("Tahoma", Font.BOLD, 13));
		secenek3.setBackground(new Color(255, 0, 102));
		secenek3.setBounds(370, 278, 137, 81);
		contentPane2.add(secenek3);
		
		JToggleButton secenek4 = new JToggleButton("Cocuk ve Aile");
		secenek4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek4.isSelected()) {
					secilenler.add(secenek4.getText());
				}
				else {
					secilenler.remove(secenek4.getText());
				}
			}
		});
		secenek4.setFont(new Font("Tahoma", Font.BOLD, 13));
		secenek4.setBackground(new Color(204, 51, 153));
		secenek4.setBounds(370, 168, 137, 81);
		contentPane2.add(secenek4);
		
		JToggleButton secenek5 = new JToggleButton("Drama");
		secenek5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek5.isSelected()) {
					secilenler.add(secenek5.getText());
				}
				else {
					secilenler.remove(secenek5.getText());
				}
			}
		});
		secenek5.setBackground(new Color(51, 153, 204));
		secenek5.setFont(new Font("Tahoma", Font.BOLD, 13));
		secenek5.setBounds(534, 168, 137, 81);
		contentPane2.add(secenek5);
		
		JToggleButton secenek6= new JToggleButton("Gerilim");
		secenek6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek6.isSelected()) {
					secilenler.add(secenek6.getText());
				}
				else {
					secilenler.remove(secenek6.getText());
				}
			}
		});
		secenek6.setForeground(new Color(255, 255, 255));
		secenek6.setFont(new Font("Tahoma", Font.BOLD, 13));
		secenek6.setBackground(new Color(153, 0, 51));
		secenek6.setBounds(698, 168, 137, 81);
		contentPane2.add(secenek6);
		
		JToggleButton secenek7 = new JToggleButton("Reality Program");
		secenek7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek7.isSelected()) {
					secilenler.add(secenek7.getText());
				}
				else {
					secilenler.remove(secenek7.getText());
				}
			}
		});
		secenek7.setFont(new Font("Tahoma", Font.BOLD, 12));
		secenek7.setBackground(new Color(255, 204, 0));
		secenek7.setBounds(534, 278, 137, 81);
		contentPane2.add(secenek7);
		
		JToggleButton secenek8 = new JToggleButton("Belgesel");
		secenek8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek8.isSelected()) {
					secilenler.add(secenek8.getText());
				}
				else {
					secilenler.remove(secenek8.getText());
				}
			}
		});
		secenek8.setFont(new Font("Tahoma", Font.BOLD, 13));
		secenek8.setBackground(new Color(0, 153, 102));
		secenek8.setBounds(534, 58, 137, 81);
		contentPane2.add(secenek8);
		
		JToggleButton secenek9 = new JToggleButton("Komedi");
		secenek9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek9.isSelected()) {
					secilenler.add(secenek9.getText());
				}
				else {
					secilenler.remove(secenek9.getText());
				}
			}
		});
		secenek9.setBackground(new Color(255, 255, 51));
		secenek9.setFont(new Font("Tahoma", Font.BOLD, 13));
		secenek9.setBounds(206, 278, 137, 81);
		contentPane2.add(secenek9);
		
		JToggleButton secenek10 = new JToggleButton("Bilim ve Doða");
		secenek10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek10.isSelected()) {
					secilenler.add(secenek10.getText());
				}
				else {
					secilenler.remove(secenek10.getText());
				}
			}
		});
		secenek10.setBackground(new Color(153, 204, 102));
		secenek10.setFont(new Font("Tahoma", Font.BOLD, 13));
		secenek10.setBounds(206, 168, 137, 81);
		contentPane2.add(secenek10);
		
		JToggleButton secenek11 = new JToggleButton("Korku");
		secenek11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek11.isSelected()) {
					secilenler.add(secenek11.getText());
				}
				else {
					secilenler.remove(secenek11.getText());
				}
			}
		});
		secenek11.setForeground(new Color(255, 255, 255));
		secenek11.setFont(new Font("Tahoma", Font.BOLD, 13));
		secenek11.setBackground(new Color(0, 0, 0));
		secenek11.setBounds(698, 278, 137, 81);
		contentPane2.add(secenek11);
		
		JToggleButton secenek12 = new JToggleButton("Anime");
		secenek12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secenek12.isSelected()) {
					secilenler.add(secenek12.getText());
				}
				else {
					secilenler.remove(secenek12.getText());
				}
			}
		});
		secenek12.setFont(new Font("Tahoma", Font.BOLD, 13));
		secenek12.setBackground(new Color(255, 222, 173));
		secenek12.setBounds(370, 58, 137, 81);
		contentPane2.add(secenek12);
		
		JButton sec = new JButton("Sec");
		sec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secilenler.size()>3) {
					lblNewLabel_1.setText("3'den fazla seçim yapamassýnýz");
					lblNewLabel_1.setVisible(true);
				}
				else if(secilenler.size()<3) {
					lblNewLabel_1.setText("3'den az seçim yapamassýnýz");
					lblNewLabel_1.setVisible(true);
				}
				else {
					lblNewLabel_1.setVisible(false);
					filmoneri(secilenler);
				}
			}
		});
		sec.setBounds(408, 422, 170, 43);
		contentPane2.add(sec);
		
		girdi=0;
	}
	void deneme() {
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		contentPane1.setBounds(100,100,1055,614);
		textField = new JTextField();
		textField.setBounds(363, 159, 262, 36);
		contentPane1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(363, 208, 262, 36);
		contentPane1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(363, 110, 262, 36);
		contentPane1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ýsim:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(305, 113, 56, 29);
		contentPane1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(363, 257, 262, 36);
		contentPane1.add(textField_2);
		textField_2.setColumns(10);
		JLabel lblNewLabel = new JLabel("E-mail:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(288, 162, 63, 29);
		contentPane1.add(lblNewLabel);
		
		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblifre.setBounds(295, 215, 56, 20);
		contentPane1.add(lblifre);
		
		JLabel lblifreTekrar = new JLabel("\u015Eifre Tekrar:");
		lblifreTekrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblifreTekrar.setBounds(241, 266, 110, 16);
		contentPane1.add(lblifreTekrar);
		
		JLabel lblNewLabel_1 = new JLabel("Hata Yazdir");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(363, 423, 262, 16);
		contentPane1.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		txtDdmmyy = new JTextField();
		txtDdmmyy.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(sayt==0) {
				txtDdmmyy.setText("");
				sayt++; }
			}
		});
		txtDdmmyy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				txtDdmmyy.setText("");
			}
		});
		txtDdmmyy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDdmmyy.setHorizontalAlignment(SwingConstants.CENTER);
		txtDdmmyy.setText("DD.MM.YY");
		txtDdmmyy.setBounds(363, 306, 262, 36);
		contentPane1.add(txtDdmmyy);
		txtDdmmyy.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Do\u011Fum Tarihi:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(230, 310, 121, 26);
		contentPane1.add(lblNewLabel_2);
		
		JButton btnKaytOlutur = new JButton("Kay\u0131t Olu\u015Ftur");
		btnKaytOlutur.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String sifre=textField_1.getText();
				String sifret=textField_2.getText();
				String mail=textField.getText();
				String tarih=txtDdmmyy.getText();
				String isim=textField_3.getText();
				if(!sifre.equals(sifret)) {
					lblNewLabel_1.setText("Sifreler eslesmemektedir.");
					lblNewLabel_1.setVisible(true);
				}
				else {
					lblNewLabel_1.setVisible(false);
					try {
						ResultSet myRs=dB.yap(sqlpass);
						while(myRs.next()) {
							if(mail.equals(myRs.getString("mail"))){
								kontrol=1;
							}
						}
					if(kontrol==1) {
						lblNewLabel_1.setVisible(true);
						lblNewLabel_1.setText("Zaten sisteme kayýtlýsýnýz.");
						kontrol=0;
					}
					else { 
						String sql;
						sql="INSERT INTO kullanici (ad,mail,sifre,Dogum_Tarihi) VALUES ('" +isim+"','"+mail +"','"+sifre +"','"+tarih+"')";
						dB.ekle(sql);
						kullanici=mail;
						tursecim();
				   }
					}catch(Exception e1) {
						System.out.println(e1);
					}
				}
				if(mail.equals("")) {
					lblNewLabel_1.setText("E-mail alaný boþ geçilemez");
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		btnKaytOlutur.setBounds(411, 366, 153, 36);
		contentPane1.add(btnKaytOlutur);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setContentPane(contentPane);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnNewButton.setBounds(0, 0, 115, 49);
		contentPane1.add(btnNewButton);
		
		
	}

	public ekran() {
		System.out.println("Programin calisabilmesi icin Mysql sifrenizi giriniz:");
		scn = new Scanner(System.in);
		sqlpass=scn.nextLine();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 614);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		mail = new JTextField();
		mail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mail.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				mail.setText("");
			}
		});
		mail.setHorizontalAlignment(SwingConstants.CENTER);
		mail.setText("E-mail");
		mail.setBounds(349, 263, 238, 35);
		contentPane.add(mail);
		mail.setColumns(10);
		
		sifre = new JTextField();
		sifre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sifre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				sifre.setText("");
			}
		});
		sifre.setHorizontalAlignment(SwingConstants.CENTER);
		sifre.setText("Sifre");
		sifre.setBounds(349, 311, 238, 33);
		contentPane.add(sifre);
		sifre.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("Hata yazdir");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(329, 181, 278, 69);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblHesabnzYokMu = new JLabel("Hesabýnýz yok mu? Hemen kayýt olun..");
		lblHesabnzYokMu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHesabnzYokMu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				deneme();
			}
		});
		lblHesabnzYokMu.setForeground(Color.BLACK);
		lblHesabnzYokMu.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent arg0) {
				lblHesabnzYokMu.setForeground(Color.BLUE);
			}
		});
		lblHesabnzYokMu.setBounds(349, 405, 238, 33);
		contentPane.add(lblHesabnzYokMu);
		
		
		JButton btnNewButton = new JButton("Giri\u015F");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ResultSet myRs=dB.yap(sqlpass);
				String mail1=mail.getText();
				String sifre1=sifre.getText();
				try {
				  while(myRs.next()) {
						if(mail1.equals(myRs.getString("mail"))){
							kontrol=1;
							if(kontrol==1) {
								if(!sifre1.equals(myRs.getString("sifre"))) {
									kontrol=2;
								}
								else {
									kontrol=1;
								}
							}
						}
					}
					if(kontrol==0) {
						lblNewLabel_2.setText("<HTML>Sisteme kayitli degilsiniz.<br/>"+"Lutfen asagidaki yere tiklayip<br/>"+"Kayit olunuz.");
						lblNewLabel_2.setVisible(true);
						kontrol=0;
					}
					if(kontrol==2) {
						lblNewLabel_2.setText("Hatalý Þifre Girdiniz.");
						lblNewLabel_2.setVisible(true);
						kontrol=0;
					}
					if(kontrol==1){
						lblNewLabel_2.setVisible(false);
						kullanici=mail1;
						arayuz();
						kontrol=0;
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnNewButton.setBounds(404, 357, 133, 35);
		contentPane.add(btnNewButton);
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblHesabnzYokMu.setForeground(Color.BLACK);
			}
		});
	}
}
