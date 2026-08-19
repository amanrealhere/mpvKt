package live.mehiz.mpvkt.ui.player.controls.components.sheets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import live.mehiz.mpvkt.R
import live.mehiz.mpvkt.ui.theme.spacing

@Composable
fun AddTrackUrlDialog(
  title: String,
  onAdd: (String) -> Unit,
  onDismissRequest: () -> Unit,
) {
  var url by remember { mutableStateOf("") }

  Dialog(onDismissRequest = onDismissRequest) {
    Surface(
      shape = MaterialTheme.shapes.medium,
      color = MaterialTheme.colorScheme.surface,
    ) {
      Column(
        modifier = Modifier.padding(MaterialTheme.spacing.medium),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
      ) {
        Text(
          text = title,
          style = MaterialTheme.typography.titleLarge,
        )

        OutlinedTextField(
          value = url,
          onValueChange = { url = it },
          modifier = Modifier.fillMaxWidth(),
          label = { Text(stringResource(R.string.player_sheets_track_url_hint)) },
          singleLine = true,
        )

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.End,
        ) {
          TextButton(onClick = onDismissRequest) {
            Text(stringResource(android.R.string.cancel))
          }

          Button(
            enabled = url.isNotBlank(),
            onClick = {
              onAdd(url.trim())
            },
          ) {
            Text(stringResource(android.R.string.ok))
          }
        }
      }
    }
  }
}
