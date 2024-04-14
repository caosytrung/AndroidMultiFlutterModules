import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

import 'constants.dart';

void main() => runApp(const SecondModuleApp());

class SecondModuleApp extends StatelessWidget {
  const SecondModuleApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Second Module',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Container(
          padding: const EdgeInsets.all(8), color: Colors.blue, child: const MyHomePage()),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  static const platform = MethodChannel(Constants.channelName);

  void _onCloseFirstModule() {
    try {
      platform.invokeMethod(Constants.finishEvent);
    } on PlatformException catch (_) {}
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.center,
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text("Welcome to Flutter Second-Module",
            textAlign: TextAlign.center, style: Theme
                .of(context)
                .textTheme
                .headlineSmall),
        const SizedBox(
          height: 64,
        ),
        ElevatedButton(
            onPressed: _onCloseFirstModule, child: const Text("Close Second Flutter Module")),
      ],
    );
  }
}
