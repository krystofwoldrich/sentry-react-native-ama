import React from 'react';
import { StyleSheet, Text, View, Image, Button } from 'react-native';
import TurboCrashModule from './js/NativeTurboCrashModule';
import * as Sentry from '@sentry/react-native';

const BANNER_URL = 'https://33fa1ur95-qdasx2mqb.sentry.dev/static/8887640552ba90952651464f9df61ce5/88556/welcome-page-performance.webp';
const DATA_URL = 'https://api.artic.edu/api/v1/artworks/129884';

Sentry.init({
  dsn: 'https://e71d589b3b0c48528c1b70ae48308733@o1357066.ingest.sentry.io/4505543765590016',
  attachScreenshot: true,
  attachViewHierarchy: true,
  sendDefaultPii: true,
});

export default function App() {
  const [data, setData] = React.useState(undefined);
  const loadData = () => {
    fetch(DATA_URL)
    .then((response) => response.json())
    .then((json) => setData(json.data.thumbnail.alt_text));
  };

  return (
    <View style={styles.container}>
      <Image
          style={styles.banner}
          source={{
          uri: BANNER_URL,
        }}
      />
      <Text style={styles.data}>{data}</Text>
      <View style={styles.btn}>
          <Button
            title='Load data'
            onPress={loadData}
          />
      </View>
      <View style={styles.btn}>
          <Button
            title='Crash on native'
            onPress={() => {
              const search = data;
              const from = 'artworks';
              TurboCrashModule!.getDataCrash({ search, from });
            }}
          />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'flex-start',
  },
  banner: {
    width: '100%',
    height: 200,
    marginBottom: 20,
 },
 data: {
  height: 100,
  margin: 20,
 },
 btn: {
  marginBottom: 20,
 }
});
