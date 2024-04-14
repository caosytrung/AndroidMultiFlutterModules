import 'package:first_module/main.dart';
import 'package:flutter/material.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const FirstModuleApp());
}

@pragma('vm:entry-point')
void firstModule() async {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const FirstModuleApp());
}

@pragma('vm:entry-point')
void secondModule() async {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const FirstModuleApp());
}