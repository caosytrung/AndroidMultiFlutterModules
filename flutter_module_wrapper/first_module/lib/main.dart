import 'package:first_module/constants.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() => runApp(const FirstModuleApp());

class FirstModuleApp extends StatelessWidget {
  const FirstModuleApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter First Module',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Container(
          padding: const EdgeInsets.all(8), color: Colors.amber, child: const MyHomePage()),
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

  void _onOpenSecondFirstModule() {
    try {
      platform.invokeMethod(Constants.openSecondModuleEvent);
    } on PlatformException catch (_) {}
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.center,
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text("Welcome to Flutter First-Module",
            textAlign: TextAlign.center, style: Theme
                .of(context)
                .textTheme
                .headlineSmall),
        const SizedBox(height: 64),
        ElevatedButton(
            onPressed: _onCloseFirstModule, child: const Text("Close First Flutter Module")),
        const SizedBox(height: 8),
        ElevatedButton(
            onPressed: _onOpenSecondFirstModule, child: const Text("Open Second Flutter")),
      ],
    );
  }
}
