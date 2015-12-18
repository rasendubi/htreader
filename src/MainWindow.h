#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QWidget>
#include <QTabWidget>

class QLabel;

class MainWindow : public QTabWidget {
public:
  MainWindow(QWidget *parent = 0);

private:
  QLabel *cardsWidget;
  QLabel *extractsWidget;
  QLabel *readingWidget;
};

#endif /* MAINWINDOW_H */
