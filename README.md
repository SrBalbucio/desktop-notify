# Based on
This project is a fork of [DS-Desktop-Notify](https://github.com/DragShot/DS-Desktop-Notify). Despite my efforts to contribute to the official project, I decided to create an alternative version with different functions than the originally intended one.

## desktop-notify ![build passing](http://img.shields.io/badge/build-passing-green.png) ![platform desktop](http://img.shields.io/badge/platform-desktop-orange.png)
A lightweight library that you can embed in your Java-powered desktop apps to display floating notifications on the desktop.

<p align="center">
  <img src="http://dragshot.webcindario.com/software/img/showcase/desktopnotify.png" alt="Preview"/>
</p>

Under development, this library allows to show small and stylish notifications on the Desktop. As the developer, all you need is to add this tiny .jar to your classpath and invoke a single static method to create and display a new notification. Something as simple as the following:

```java
import desktop.notify.DesktopNotify;

DesktopNotify.showDesktopMessage(
    "This is a notification",
    "With DS Desktop Notify, displaying notifications on the screen is quick and easy!",
    DesktopNotify.SUCCESS);
```

You can customize your notification to make it show what you want. You can customize its looks with a title, a message, an icon (or use a default one) and even the fonts and colors, picking one of the provided themes or creating one of your own. Behavior can also be customized with a given time before the notification expires (it can be infinite too, so only a click will make it go away), and an action event on click. You don't need to worry about the bounds nor where you should break lines (as in JOptionPane), because all of this is automatically measured before showing your notification.

You can also read the [wiki](https://github.com/DragShot/DS-Desktop-Notify/wiki) for more instructions on how to use this library.

So, no matter what your application is about, if you need to show pop-up notifications on the Desktop in any moment, you can use this library to deal with that.

## Features
- Lightweight and easy to use.
- Create and show your notification with a single code line!
- The notifications can be closed by mouse clicking, or have an specific time on screen.
- They can wait on queue if there's no room to show them all.
- Action events for each notification.
- Notifications can be posted from external processes via command line.
- They won't mess with the taskbar in Windows PCs!
- It leaves no traces: the service thread automatically stops when there are no more notifications to show. It is also started again when new notifications arrive.

## Requirements
- Windows XP/Vista/7/8/10, Linux, Mac-OS X
- Java 8 or higher
