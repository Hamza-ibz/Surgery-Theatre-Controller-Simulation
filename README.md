# Surgery-Theatre-Controller-Simulation

The GUI application that you need to create is a basic ‘surgery theatre controller’ simulation. The required design is illustrated in Figure 5 below.


The application comprises several regions representing controls for clocks (a real time and an elapsed time), room temperature, humidity and pressure, 
lighting control, and a medical gases display. Each area on screen comprises JavaFX nodes and controls, such as buttons, labels, text, image views and
graphical shapes.

b) With reference to the seven regions in the display, User interaction is as follows:
- The ‘medical gases’ region has no interaction and is purely a visual display.
  6
- The ‘daytime clock’ region should have no user interaction but displays the current time which can be derived programmatically in Java from the CPU system clock.
- For the ‘elapsed time’ region (which displays seconds, minutes, and hours), a timer that increments each second should be started when the User selects the ‘start’ button. On selecting the ‘stop’ button the timer should halt. Selecting the ’start’ button again will continue the timer from its current setting (i.e., continual selection of start/stop should act like a pause and resume feature). Selecting the ‘reset’ button should set the elapsed time back to zero.
- For the temperature control region, the selection of the up/down buttons should increment and decrement the temperature display accordingly, in increments of 0.1 degrees Celsius. In addition, the temperature setting should not exceed 27.5 degrees Celsius, or drop below 10.0 degrees Celsius.
- For the humidity control region, the selection of the up/down buttons should increment and decrement the humidity display accordingly, in increments of one percent. In addition, the humidity setting should not exceed 55 per cent, or drop below 30 percent.
- For the pressure control region, the selection of the up/down buttons should increment and decrement the pressure display accordingly, in increments of 10 kPa. In addition, the pressure setting should not exceed 120 kPa, or drop below 50 kPa.
- For the light control region, each of the three light controls has buttons to increase or decrease the light setting. There are six light setting levels in each case. If the User presses the increase (+) button the light setting moves to the next level, and if the User presses the decrease (-) button the light seeing moves to the previous level. The result of this interaction is illustrated in Figure 6, which illustrates the results of interactions in several regions of the display.
