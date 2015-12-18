#include "MainWindow.h"
#include <QLabel>

MainWindow::MainWindow(QWidget *parent) : QTabWidget(parent) {
  this->setTabPosition(QTabWidget::West);

  cardsWidget = new QLabel("Cards widget");
  extractsWidget = new QLabel("Extracts widget");
  readingWidget = new QLabel("Reading widget");

  this->addTab(cardsWidget, "Cards");
  this->addTab(extractsWidget, "Extracts");
  this->addTab(readingWidget, "Reading");
}
