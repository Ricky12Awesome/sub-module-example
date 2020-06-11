fun DependencyHandler.shadowApi(notation: Any) {
  shadow(notation)
  api(notation)
}

dependencies {
  shadowApi(kotlin("stdlib-jdk8"))
}