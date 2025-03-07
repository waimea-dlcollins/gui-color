/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener {

    // Fields to hold the UI elements

    private lateinit var redJTextField: JTextField
    private lateinit var greenJTextField: JTextField
    private lateinit var blueJTextField: JTextField

    private lateinit var redUpButton: JButton
    private lateinit var redDownButton: JButton

    private lateinit var greenUpButton: JButton
    private lateinit var greenDownButton: JButton

    private lateinit var blueUpButton: JButton
    private lateinit var blueDownButton: JButton


    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin color picker"
        contentPane.preferredSize = Dimension(600, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 30)

        redUpButton = JButton("+")
        redUpButton.horizontalAlignment = SwingConstants.CENTER
        redUpButton.bounds = Rectangle(190, 150, 100, 100)
        redUpButton.font = defaultFont
        add(redUpButton)

        greenUpButton = JButton("+")
        greenUpButton.bounds = Rectangle(10,270,100,100)
        greenUpButton.font = defaultFont
        greenUpButton.addActionListener(this)      // Handle any clicks
        add(greenUpButton)

        blueUpButton = JButton("+")
        blueUpButton.bounds = Rectangle(10,80,100,100)
        blueUpButton.font = defaultFont
        blueUpButton.addActionListener(this)      // Handle any clicks
        add(blueUpButton)

        redDownButton = JButton("+")
        redDownButton.horizontalAlignment = SwingConstants.CENTER
        redDownButton.bounds = Rectangle(50, 50, 500, 100)
        redDownButton.font = defaultFont
        add(redDownButton)

        greenDownButton = JButton("+")
        greenDownButton.horizontalAlignment = SwingConstants.CENTER
        greenDownButton.bounds = Rectangle(50, 50, 500, 100)
        greenDownButton.font = defaultFont
        add(greenDownButton)

        blueDownButton = JButton("+")
        blueDownButton.horizontalAlignment = SwingConstants.CENTER
        blueDownButton.bounds = Rectangle(50, 50, 500, 100)
        blueDownButton.font = defaultFont
        add(blueDownButton)

        redJTextField = JTextField("+")
        redJTextField.horizontalAlignment = SwingConstants.CENTER
        redJTextField.bounds = Rectangle(50, 50, 500, 100)
        redJTextField.font = defaultFont
        add(redJTextField)

        greenJTextField = JTextField("+")
        greenJTextField.horizontalAlignment = SwingConstants.CENTER
        greenJTextField.bounds = Rectangle(50, 50, 500, 100)
        greenJTextField.font = defaultFont
        add(greenJTextField)

        blueJTextField = JTextField("+")
        blueJTextField.horizontalAlignment = SwingConstants.CENTER
        blueJTextField.bounds = Rectangle(50, 50, 500, 100)
        blueJTextField.font = defaultFont
        add(blueJTextField)

    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            redUpButton -> {
                redJTextField.text = "You clicked the button!"
            }
        }
    }

}

