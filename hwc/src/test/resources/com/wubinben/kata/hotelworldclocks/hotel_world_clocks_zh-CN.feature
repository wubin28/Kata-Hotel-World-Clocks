#language:zh-CN
功能: 酒店世界时钟招式
  为了能尽量容易地调整酒店大堂里不同城市的时钟时间，
  作为酒店雇员，
  我想调整任一城市的时钟的时间后，其余城市的时钟的时间自动调整。

  场景: 将北京的时钟的时间调整正确
    假如 一个酒店大堂有五个城市的时钟
    并且 "伦敦"正实行夏时制
    并且 "纽约"正实行夏时制
    并且 "北京"未实行夏时制
    并且 "莫斯科"未实行夏时制
    并且 "悉尼"未实行夏时制
    当 我将"北京"的时钟的时间调整到9
    那么 城市"北京"的时钟的时间应该是9
    并且 the time of the clock of "伦敦" should be 2
    并且 the time of the clock of "莫斯科" should be 5
    并且 the time of the clock of "悉尼" should be 11
    并且 the time of the clock of "纽约" should be 21

  场景: The daylight saving period of London ends
    假如 a hotel lobby has five clocks
    并且 the DST period of "London" ends
    并且 the DST period of "New York" does not end
    并且 "Beijing" does not use the DST
    并且 "Moscow" does not use the DST
    并且 "Sydney" does not use the DST
    当 I adjust the time of the clock of "London" to be 0 due to the end of DST
    那么 the time of the clock of "Beijing" should be 8
    并且 the time of the clock of "London" should be 0
    并且 the time of the clock of "Moscow" should be 4
    并且 the time of the clock of "Sydney" should be 10
    并且 the time of the clock of "New York" should be 20

