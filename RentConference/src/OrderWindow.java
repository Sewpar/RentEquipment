import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EnumSet;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OrderWindow extends Main{
	
	static OrderWindow window = new OrderWindow();
    JFrame frame = new JFrame();
    static int NumberOfDays = 0;
	static void On()
	{
		window.frame.setVisible(true);
		
	}
	static void Off()
	{
		window.frame.setVisible(false);

	}
	static void clearAll(ButtonGroup group, JTextArea text)
	{
		group.clearSelection();
		text.setText("Total: " + total + " EUR");
	}
	
	public OrderWindow() {
		total = 0;
		frame.getContentPane().setBackground(new Color(153, 204, 204));
		frame.setBackground(new Color(153, 204, 204));
		frame.setResizable(false);
		frame.setTitle("Order window");
		frame.setBounds(100, 100, 843, 359);
		frame.getContentPane().setLayout(null);
				
		JTextArea TextRoom = new JTextArea();
		TextRoom.setFont(new Font("Dialog", Font.PLAIN, 17));
		TextRoom.setBackground(new Color(153, 204, 204));
		TextRoom.setText("Please select a room.");
		TextRoom.setEditable(false);
		TextRoom.setBounds(524, 38, 304, 186);
		frame.getContentPane().add(TextRoom);
	
		JRadioButton AuditoriumButton = new JRadioButton ("Auditorium");
		AuditoriumButton.setBackground(new Color(153, 204, 204));
		AuditoriumButton.setBounds(378, 38, 117, 25);
		frame.getContentPane().add(AuditoriumButton);
		
		JRadioButton HallButton = new JRadioButton ("Hall");
		HallButton.setBackground(new Color(153, 204, 204));
		HallButton.setBounds(378, 112, 117, 25);
		frame.getContentPane().add(HallButton);
		
		JRadioButton RoomButton = new JRadioButton ("Room");
		RoomButton.setBackground(new Color(153, 204, 204));
		RoomButton.setBounds(378, 75, 117, 25);
		frame.getContentPane().add(RoomButton);		
		
		JRadioButton ClassroomButton = new JRadioButton("Classroom");
		ClassroomButton.setBackground(new Color(153, 204, 204));
		ClassroomButton.setBounds(378, 186, 117, 25);
		frame.getContentPane().add(ClassroomButton);
		
		JRadioButton ChamberButton = new JRadioButton("Chamber");
		ChamberButton.setBackground(new Color(153, 204, 204));
		ChamberButton.setBounds(378, 149, 117, 25);
		frame.getContentPane().add(ChamberButton);
		
		ButtonGroup RoomButtonGroup = new ButtonGroup();
		
		RoomButtonGroup.add(ClassroomButton);
		RoomButtonGroup.add(ChamberButton);
		RoomButtonGroup.add(AuditoriumButton);
		RoomButtonGroup.add(HallButton);
		RoomButtonGroup.add(RoomButton);
		
		JButton HelpMeButton = new JButton("Help me choose!");
		HelpMeButton.setBounds(563, 230, 200, 44);
		frame.getContentPane().add(HelpMeButton);
		
		JButton BackButton = new JButton("Back");
		BackButton.setBounds(12, 322, 82, 25);
		frame.getContentPane().add(BackButton);
		
		JButton NextButton = new JButton("Next");
		NextButton.setBounds(711, 322, 117, 25);
		frame.getContentPane().add(NextButton);
		
		JTextArea TotalText = new JTextArea();
		TotalText.setBackground(new Color(153, 204, 204));
		TotalText.setFont(new Font("Dialog", Font.PLAIN, 20));
		TotalText.setEditable(false);
		TotalText.setText("Total: " + total + " EUR");
		TotalText.setBounds(498, 320, 178, 32);
		frame.getContentPane().add(TotalText);
		
		JTextPane ProjectorText = new JTextPane();
		ProjectorText.setBackground(new Color(153, 204, 204));
		ProjectorText.setBounds(77, 75, 156, 23);
		ProjectorText.setText(Equipment.projektorius.getName() + " (" + Equipment.projektorius.getPrice() + " EUR)");
		frame.getContentPane().add(ProjectorText);
		
		JTextPane LargeSpeakerText = new JTextPane();
		LargeSpeakerText.setBackground(new Color(153, 204, 204));
		LargeSpeakerText.setBounds(77, 105, 156, 23);
		LargeSpeakerText.setText(Equipment.garsiakalbis.getName() + " (" + Equipment.garsiakalbis.getPrice() + " EUR)");
		frame.getContentPane().add(LargeSpeakerText);
		
		JTextPane LaserPointerText = new JTextPane();
		LaserPointerText.setBackground(new Color(153, 204, 204));
		LaserPointerText.setBounds(77, 136, 212, 23);
		LaserPointerText.setText(Equipment.lazeris.getName() + " (" + Equipment.lazeris.getPrice() + " EUR)");
		frame.getContentPane().add(LaserPointerText);
		
		JTextPane MicrophoneText = new JTextPane();
		MicrophoneText.setBackground(new Color(153, 204, 204));
		MicrophoneText.setBounds(77, 163, 191, 23);
		MicrophoneText.setText(Equipment.mikrofonas.getName() + " (" + Equipment.mikrofonas.getPrice() + " EUR)");
		frame.getContentPane().add(MicrophoneText);
		
		JTextPane WhiteBoardText = new JTextPane();
		WhiteBoardText.setBackground(new Color(153, 204, 204));
		WhiteBoardText.setBounds(77, 197, 218, 23);
		WhiteBoardText.setText(Equipment.lenta.getName() + " (" + Equipment.lenta.getPrice() + " EUR)");
		frame.getContentPane().add(WhiteBoardText);
		
		JTextPane ProjectionScreenText = new JTextPane();
		ProjectionScreenText.setBackground(new Color(153, 204, 204));
		ProjectionScreenText.setBounds(77, 260, 218, 23);
		ProjectionScreenText.setText(Equipment.ekranas.getName() + " (" + Equipment.ekranas.getPrice() + " EUR)");
		frame.getContentPane().add(ProjectionScreenText);
		
		JTextPane AmplifierText = new JTextPane();
		AmplifierText.setBackground(new Color(153, 204, 204));
		AmplifierText.setBounds(77, 233, 156, 23);
		AmplifierText.setText(Equipment.stiprintuvas.getName() + " (" + Equipment.stiprintuvas.getPrice() + " EUR)");
		frame.getContentPane().add(AmplifierText);
		
		JSpinner ProjectorSpinner = new JSpinner();
		ProjectorSpinner.setEditor(new JSpinner.DefaultEditor(ProjectorSpinner));
		ProjectorSpinner.addChangeListener(new ChangeListener()
		{
			int change = 0;
			public void stateChanged(ChangeEvent arg0) {
				if (change < (int) ProjectorSpinner.getValue())
				total = total + Equipment.projektorius.getPrice();
				else if (change > (int) ProjectorSpinner.getValue())
				total = total -  Equipment.projektorius.getPrice();
				TotalText.setText("Total: " + total + " EUR");
				change = (int) ProjectorSpinner.getValue();
	}
		});
		ProjectorSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		ProjectorSpinner.setBounds(12, 77, 53, 20);
		frame.getContentPane().add(ProjectorSpinner);
		
		JSpinner LargeSpeakerSpinner = new JSpinner();
		LargeSpeakerSpinner.setEditor(new JSpinner.DefaultEditor(LargeSpeakerSpinner));
		LargeSpeakerSpinner.addChangeListener(new ChangeListener()
		{
			int change = 0;
			public void stateChanged(ChangeEvent arg0) {
				if (change < (int) LargeSpeakerSpinner.getValue())
				total = total + Equipment.garsiakalbis.getPrice();
				else if (change > (int) LargeSpeakerSpinner.getValue())
				total = total -  Equipment.garsiakalbis.getPrice();
				TotalText.setText("Total: " + total + " EUR");
				change = (int) LargeSpeakerSpinner.getValue();
	}
		});
		LargeSpeakerSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		LargeSpeakerSpinner.setBounds(12, 113, 53, 20);
		frame.getContentPane().add(LargeSpeakerSpinner);
		
		JSpinner LaserPointerSpinner = new JSpinner();
		LaserPointerSpinner.setEditor(new JSpinner.DefaultEditor(LaserPointerSpinner));

		LaserPointerSpinner.addChangeListener(new ChangeListener()
		{
			int change = 0;
			public void stateChanged(ChangeEvent arg0) {
				if (change < (int) LaserPointerSpinner.getValue())
				total = total + Equipment.lazeris.getPrice();
				else if (change > (int) LaserPointerSpinner.getValue())
				total = total -  Equipment.lazeris.getPrice();
				TotalText.setText("Total: " + total + " EUR");
				change = (int) LaserPointerSpinner.getValue();
	}
		});
		LaserPointerSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		LaserPointerSpinner.setBounds(12, 140, 53, 20);
		frame.getContentPane().add(LaserPointerSpinner);
		
		JSpinner MicrophoneSpinner = new JSpinner();
		MicrophoneSpinner.setEditor(new JSpinner.DefaultEditor(MicrophoneSpinner));
		MicrophoneSpinner.addChangeListener(new ChangeListener()
		{
			int change = 0;
			public void stateChanged(ChangeEvent arg0) {
				if (change < (int) MicrophoneSpinner.getValue())
				total = total + Equipment.mikrofonas.getPrice();
				else if (change > (int) MicrophoneSpinner.getValue())
				total = total -  Equipment.mikrofonas.getPrice();
				TotalText.setText("Total: " + total + " EUR");
				change = (int) MicrophoneSpinner.getValue();
			}
		});
		MicrophoneSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		MicrophoneSpinner.setBounds(12, 170, 53, 20);
		frame.getContentPane().add(MicrophoneSpinner);
		
		JSpinner WhiteBoardSpinner = new JSpinner();
		WhiteBoardSpinner.setEditor(new JSpinner.DefaultEditor(WhiteBoardSpinner));
		WhiteBoardSpinner.addChangeListener(new ChangeListener()
		{
			int change = 0;
			public void stateChanged(ChangeEvent arg0) {
				if (change < (int) WhiteBoardSpinner.getValue())
				total = total + Equipment.lenta.getPrice();
				else if (change > (int) WhiteBoardSpinner.getValue())
				total = total -  Equipment.lenta.getPrice();
				TotalText.setText("Total: " + total + " EUR");
				change = (int) WhiteBoardSpinner.getValue();
	}
		});
		WhiteBoardSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		WhiteBoardSpinner.setBounds(12, 201, 53, 20);
		frame.getContentPane().add(WhiteBoardSpinner);
		
		JSpinner AmplifierSpinner = new JSpinner();
		AmplifierSpinner.setEditor(new JSpinner.DefaultEditor(AmplifierSpinner));
		AmplifierSpinner.addChangeListener(new ChangeListener()
				{
			int change = 0;
			public void stateChanged(ChangeEvent arg0) {
				if (change < (int) AmplifierSpinner.getValue())
				total = total + Equipment.stiprintuvas.getPrice();
				else if (change > (int) AmplifierSpinner.getValue())
				total = total -  Equipment.stiprintuvas.getPrice();
				TotalText.setText("Total: " + total + " EUR");
				change = (int) AmplifierSpinner.getValue();
			}
				});
		AmplifierSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		AmplifierSpinner.setBounds(12, 237, 53, 20);
		frame.getContentPane().add(AmplifierSpinner);
		
		JSpinner ProjectionScreenSpinner = new JSpinner();
		ProjectionScreenSpinner.setEditor(new JSpinner.DefaultEditor(ProjectionScreenSpinner));
		ProjectionScreenSpinner.addChangeListener(new ChangeListener()
		{
			int change = 0;
		public void stateChanged(ChangeEvent arg0) {
			if (change < (int) ProjectionScreenSpinner.getValue())
			total = total + Equipment.ekranas.getPrice();
			else if (change > (int) ProjectionScreenSpinner.getValue())
			total = total -  Equipment.ekranas.getPrice();
			TotalText.setText("Total: " + total + " EUR");
			change = (int) ProjectionScreenSpinner.getValue();
	}

		});
		ProjectionScreenSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		ProjectionScreenSpinner.setBounds(12, 264, 53, 20);
		frame.getContentPane().add(ProjectionScreenSpinner);
		
		JTextArea EquipmentText = new JTextArea();
		EquipmentText.setText("Please select the needed equipment.");
		EquipmentText.setFont(new Font("Dialog", Font.PLAIN, 17));
		EquipmentText.setEditable(false);
		EquipmentText.setBackground(new Color(153, 204, 204));
		EquipmentText.setBounds(25, 31, 345, 32);
		frame.getContentPane().add(EquipmentText);
		
		JTextArea NumberOfDaysText = new JTextArea();
		NumberOfDaysText.setText("Number of days:");
		NumberOfDaysText.setFont(new Font("Dialog", Font.PLAIN, 20));
		NumberOfDaysText.setEditable(false);
		NumberOfDaysText.setBackground(new Color(153, 204, 204));
		NumberOfDaysText.setBounds(151, 315, 178, 32);
		frame.getContentPane().add(NumberOfDaysText);
		
		JSpinner NumberOfDaysSpinner = new JSpinner();
		NumberOfDaysSpinner.setEditor(new JSpinner.DefaultEditor(NumberOfDaysSpinner));
		NumberOfDaysSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		NumberOfDaysSpinner.addChangeListener(new ChangeListener()
		{
			int DayChange = 0;
			public void stateChanged(ChangeEvent arg0) {
				NumberOfDays = (int) NumberOfDaysSpinner.getValue();
				if (DayChange < (int) NumberOfDaysSpinner.getValue())
				total = total + (total * NumberOfDays);
				else if (DayChange > (int) NumberOfDaysSpinner.getValue())
					total = total - (total * NumberOfDays);
				TotalText.setText("Total: " + total + " EUR");
				DayChange = (int) NumberOfDaysSpinner.getValue();
			}
		});
		NumberOfDaysSpinner.setBounds(327, 320, 53, 20);
		frame.getContentPane().add(NumberOfDaysSpinner);
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BackButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				OrderWindow.Off();
				MainWindow.On();
			}
		});
		HelpMeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				OrderWindow.Off();
				HelpMeChoose.On();
			}
		});
		NextButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		});

AuditoriumButton.addItemListener(new ItemListener()
{
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		if (arg0.getStateChange() == ItemEvent.SELECTED)
		{
			TextRoom.setText("The selected room is:\n" + Rooms.auditorija.getName() + "\nthe room can fit " + Rooms.auditorija.getArea() + " people\nthe rent price is " + Rooms.auditorija.getPrice() + " euros for a day.");
			total = total + Rooms.auditorija.getPrice();
			TotalText.setText("Total: " + total + " EUR");
		}
		else if (arg0.getStateChange() == ItemEvent.DESELECTED)
		{
			total = total - Rooms.auditorija.getPrice();
			TotalText.setText("Total: " + total + " EUR");
		}
	}
});
HallButton.addItemListener(new ItemListener()
{
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		if (arg0.getStateChange() == ItemEvent.SELECTED)
		{
			TextRoom.setText("The selected room is:\n" + Rooms.sale.getName() + "\nthe room can fit " + Rooms.sale.getArea() + " people\nthe rent price is " + Rooms.sale.getPrice() + " euros for a day.");
			total = total + Rooms.sale.getPrice();
			TotalText.setText("Total: " + total + " EUR");
		}
		else if (arg0.getStateChange() == ItemEvent.DESELECTED)
		{
			total = total - Rooms.sale.getPrice();
			TotalText.setText("Total: " + total + " EUR");
		}
	}
});
RoomButton.addItemListener(new ItemListener()
{
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		if (arg0.getStateChange() == ItemEvent.SELECTED)
		{
			TextRoom.setText("The selected room is:\n" + Rooms.kambarys.getName() + "\nthe room can fit " + Rooms.kambarys.getArea() + " people\nthe rent price is " + Rooms.kambarys.getPrice() + " euros for a day.");
			total = total + Rooms.kambarys.getPrice();
			TotalText.setText("Total: " + total + " EUR");
		}
		else if (arg0.getStateChange() == ItemEvent.DESELECTED)
		{
			total = total - Rooms.kambarys.getPrice();
			TotalText.setText("Total: " + total + " EUR");
		}
	}
});
ClassroomButton.addItemListener(new ItemListener()
{
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		if (arg0.getStateChange() == ItemEvent.SELECTED)
		{
			TextRoom.setText("The selected room is:\n" + Rooms.klase.getName() + "\nthe room can fit " + Rooms.klase.getArea() + " people\nthe rent price is " + Rooms.klase.getPrice() + " euros for a day.");
			total = total + Rooms.klase.getPrice();
			TotalText.setText("Total: " + total + " EUR");
		}
		else if (arg0.getStateChange() == ItemEvent.DESELECTED)
		{
			total = total - Rooms.klase.getPrice();
			TotalText.setText("Total: " + total + " EUR");
		}
	}
});
ChamberButton.addItemListener(new ItemListener()
{
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		if (arg0.getStateChange() == ItemEvent.SELECTED)
		{
			TextRoom.setText("The selected room is:\n" + Rooms.kambariukas.getName() + "\nthe room can fit " + Rooms.kambariukas.getArea() + " people\nthe rent price is " + Rooms.kambariukas.getPrice() + " euros for a day.");
			total = total + Rooms.kambariukas.getPrice();
			TotalText.setText("Total: " + total + " EUR");
		}
		else if (arg0.getStateChange() == ItemEvent.DESELECTED)
		{
			total = total - Rooms.kambariukas.getPrice();
			TotalText.setText("Total: " + total + " EUR");
		}
	}
});
	
	clearAll(RoomButtonGroup, TotalText);
}
}