/**
 * desc 降序
 */
var visitHQPromotionData = [
    {
      deployEndDate: "2022/11/01",
      deployStartDate: "2022/11/01",
      promotionLink: "/0c8p00000008OQOAA2",
      promotionName: "キーマン接触",
      talkEndDate: "2022/12/01",
      talkStartDate: "2022/09/01",
      taskCount: 1,
    },
    {
      deployEndDate: "2022/09/01",
      deployStartDate: "2022/09/01",
      promotionLink: "/0c8p00000008OLdAAM",
      promotionName: "テスト_承認プロセス_01",
      talkEndDate: "2022/09/06",
      talkStartDate: "2022/09/01",
      taskCount: 0,
      term: "事前商談",
    },
    {
      deployEndDate: "2022/12/30",
      deployStartDate: "2022/06/01",
      promotionLink: "/0c8p00000008OZpAAM",
      promotionName: "キーマン接触",
      talkEndDate: "2022/08/31",
      talkStartDate: "2022/06/01",
      taskCount: 0,
      term: "展開",
    },
    {
      deployEndDate: "2022/12/30",
      deployStartDate: "2022/06/01",
      promotionLink: "/0c8p00000008PEdAAM",
      promotionName: "プロモーション6_週次指示002",
      talkEndDate: "2022/08/31",
      talkStartDate: "2022/06/01",
      taskCount: 0,
      term: "展開",
    },
    {
      deployEndDate: "2022/12/30",
      deployStartDate: "2022/06/01",
      promotionLink: "/0c8p00000008OZfAAM",
      promotionName: "プロモーション8",
      talkEndDate: "2022/08/31",
      talkStartDate: "2022/06/01",
      taskCount: 0,
      term: "展開",
    },
    {
      deployEndDate: "2022/12/30",
      deployStartDate: "2022/06/01",
      promotionLink: "/0c8p00000008PDzAAM",
      promotionName: "プロモーション9",
      talkEndDate: "2022/08/31",
      talkStartDate: "2022/06/01",
      taskCount: 0,
      term: "展開",
    },
    {
      deployEndDate: "2022/12/30",
      deployStartDate: "2022/06/01",
      promotionLink: "/0c8p00000008Q3PAAU",
      promotionName: "打鍵_プロモーション01",
      talkEndDate: "2022/08/30",
      talkStartDate: "2022/06/01",
      taskCount: 1,
    },
    {
      deployEndDate: "2023/01/01",
      deployStartDate: "2022/01/01",
      promotionLink: "/0c8p00000008PxeAAE",
      promotionName: "ADD＿PHOTOテスト",
      talkEndDate: "2023/01/01",
      talkStartDate: "2022/01/01",
      taskCount: 1,
      term: "事前商談",
    },
    {
      deployEndDate: "2023/01/01",
      deployStartDate: "2022/01/01",
      promotionLink: "/0c8p00000008OQTAA2",
      promotionName: "定番冷ケース画像",
      talkEndDate: "2023/01/01",
      talkStartDate: "2022/01/01",
      taskCount: 1,
      term: "事前商談",
    },
  ];
  
  /**
   *
   * @param {对象属性} field
   * @param {排序方式} reverse
   * @param {数据类型} primer
   * @returns 排序结果
   */
  var sortBy = (field, reverse, primer) => {
    const key = primer
      ? function (x) {
          // //数据类型判断
          // if ((primer = Date)) {
          //   return new primer(x[field]).getTime();
          // }
          return primer(x[field]);
        }
      : function (x) {
          return x[field];
        };
  
    return function (a, b) {
      a = key(a);
      b = key(b);
      if (!a && b) {
        if (a === undefined) return reverse * -9999;
        return reverse * -999;
      }
      if (!b && a) {
        if (b === undefined) return reverse * 9999;
        return reverse * 999;
      }
      return reverse * ((a > b) - (b > a));
    };
  };
  var sortDirection = "desc"; // desc降序
  const cloneData = [...visitHQPromotionData];
  cloneData.sort(sortBy("talkEndDate", sortDirection === "asc" ? 1 : -1));
  console.log(cloneData);
  