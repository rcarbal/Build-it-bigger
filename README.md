# Build it Bigger

This the fourth project in the Udacity Android Developer Nanodegree.

## Features

Build it bigger, contains multiple flavors that uses multiple libraries and Cloud Google endpoints. An external android library is used in the paid flavor of the application.  A Google Cloud endpoint server is used to connect the android libray with an external java library to display the jokes.

## Implementation.

- Free application flavor with ads.
- Paid application flavor with no ads.
- Paid version uses external android library to show jokes.
- Google Cloud Enpoints is used to connect the external android library to an external Java library.

## Google Cloud endpoints instruction.


The android library is setup through gradle dependency implementation.  The backend that connects to the java library are also ran local in the device.  In order to open the server endpoints:
  
  
  - Open the the right gradle tab.
  - Under backend go to app engine standard environmnet.
  - Start the endpoints with gradle task appengineStart.
  - Stop  the endpoints with gradle task appengineStop.

  <img src="https://user-images.githubusercontent.com/20021751/38526521-8d3c57bc-3c0b-11e8-94f8-4a0579ff0512.png" width="900">
