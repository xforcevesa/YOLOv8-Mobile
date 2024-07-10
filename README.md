# YOLOv8-Mobile

YOLOv8-Mobile 是为移动设备设计的 YOLOv8 目标检测模型的优化版本。该项目利用 NCNN 推理框架的强大功能，在移动平台上提供实时目标检测能力。此外，它还集成了 OpenCV-Mobile 用于图像处理任务。

在安卓手机上运行你的 YOLOv8！

APK可从以下路径下载：

1. Gitee: https://gitee.com/xforcevesa/YOLOv8-Mobile/releases/tag/v1.0
2. GitHub: https://github.com/xforcevesa/YOLOv8-Mobile/releases/tag/v1.0

YOLOv8-Mobile is an optimized version of the YOLOv8 object detection model designed for mobile devices. This project leverages the power of the NCNN inference framework to deliver real-time object detection capabilities on mobile platforms. Additionally, it integrates with OpenCV-Mobile for image processing tasks.

Run your YOLOv8 in an Android mobile!

You can download the APK from the following paths:

1. Gitee: https://gitee.com/xforcevesa/YOLOv8-Mobile/releases/tag/v1.0
2. GitHub: https://github.com/xforcevesa/YOLOv8-Mobile/releases/tag/v1.0

## Table of Contents
- [YOLOv8-Mobile](#yolov8-mobile)
  - [Table of Contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Features](#features)
  - [Installation](#installation)
    - [Prerequisites](#prerequisites)
    - [Clone the Repository](#clone-the-repository)
    - [Building the Project](#building-the-project)
      - [Android](#android)
      - [iOS](#ios)
  - [Usage](#usage)
    - [Android](#android-1)
  - [Performance](#performance)
  - [License](#license)
  - [Acknowledgements](#acknowledgements)

## Introduction

YOLOv8-Mobile aims to bring the efficiency and accuracy of the YOLOv8 model to mobile devices. By utilizing the NCNN inference framework, this project ensures that object detection tasks can be performed efficiently, even on devices with limited computational resources.

## Features

- **Optimized for Mobile:** Leverages NCNN for efficient inference on mobile devices.
- **Real-time Object Detection:** Capable of performing real-time object detection with high accuracy.
- **OpenCV Integration:** Uses OpenCV-Mobile for various image processing tasks.
- **Cross-Platform Support:** Supports both Android and iOS platforms.

## Installation

### Prerequisites

- Android Studio / Xcode
- CMake
- NCNN
- OpenCV-Mobile

### Clone the Repository

```bash
git clone https://github.com/xforcevesa/YOLOv8-Mobile.git
cd YOLOv8-Mobile
```

### Building the Project

#### Android

1. Open the project in Android Studio.
2. Sync the project with Gradle files.
3. Build the APK using Android Studio.

#### iOS

1. Open the Xcode project located in the `ios` directory.
2. Set up the necessary dependencies.
3. Build and run the project on your device or simulator.

## Usage

### Android

1. Install the APK from the release on your Android device.
2. Launch the application.
3. Point your camera at objects to see real-time detection results.

## Performance

YOLOv8-Mobile is designed to perform efficiently on mobile devices.

It performs around 20~30 FPS on my Snapdragon 8Gen1 phone.

## License

This project is licensed under the Apache License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [YOLOv8](https://github.com/ultralytics/yolov8)
- [NCNN](https://github.com/Tencent/ncnn)
- [OpenCV-Mobile](https://github.com/nihui/opencv-mobile)

Special thanks to the developers of these projects for their hard work and dedication.

This `README.md` provides a comprehensive overview of the YOLOv8-Mobile project, including installation instructions, usage details, and acknowledgments. Feel free to modify it to better suit the specifics of your project.
