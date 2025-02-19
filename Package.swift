// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "Q2iScannerPlugin",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "Q2iScannerPlugin",
            targets: ["ScannerPluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "ScannerPluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/ScannerPluginPlugin"),
        .testTarget(
            name: "ScannerPluginPluginTests",
            dependencies: ["ScannerPluginPlugin"],
            path: "ios/Tests/ScannerPluginPluginTests")
    ]
)